package org.nypl.simplified.simplye

import android.app.Application
import com.instabug.library.Instabug
import com.instabug.library.invocation.InstabugInvocationEvent
import org.librarysimplified.instabug.spi.InstabugProviderType
import org.librarysimplified.instabug.spi.InstabugType
import org.nypl.simplified.main.MainUIThreadService
import org.slf4j.LoggerFactory
import java.io.FileNotFoundException
import java.io.IOException
import java.util.Properties

/**
 * Initializes Instabug
 */
class InstabugProvider : InstabugProviderType {

    private val logger = LoggerFactory.getLogger(InstabugProvider::class.java)

    override fun create(context: Application): InstabugType? {
        logger.debug("Creating Instabug provider...")
        if (BuildConfig.DEBUG) {
            return null
        } else {
            return try {
                val creds = loadCredentials(context)
                initializeInstabug(context, creds)
                return InstabugInit()
            } catch (e: FileNotFoundException) {
                this.logger.debug("Instabug configuration not present: ", e)
                null
            } catch (e: IOException) {
                throw IllegalStateException("could not initialize Instabug", e)
            }
        }
    }

    private class InstabugInit : InstabugType

    /**
     * Does the actual initialization on the main UI thread (required)
     */
    private fun initializeInstabug(context: Application, creds: String) {
        logger.debug("Initializing Instabug...")
        MainUIThreadService().runOnUIThread {
            Instabug.Builder(context, creds).setInvocationEvents(
                    InstabugInvocationEvent.SHAKE,
                    InstabugInvocationEvent.FLOATING_BUTTON).build()
        }
    }

    /**
     * Loads credentials from assets
     */
    private fun loadCredentials(context: Application): String {
        logger.debug("Loading credentials from assets...")
        val properties = Properties()
        context.assets.open("instabug.conf").use { stream ->
            properties.load(stream)
            return properties.getProperty("instabug.token")
        }
    }
}
