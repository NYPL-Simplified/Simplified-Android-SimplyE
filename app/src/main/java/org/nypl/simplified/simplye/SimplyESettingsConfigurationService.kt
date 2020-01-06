package org.nypl.simplified.simplye

import org.nypl.simplified.ui.settings.SettingsConfigurationServiceType

/**
 * The settings configuration service for the application.
 */

class SimplyESettingsConfigurationService : SettingsConfigurationServiceType {

  override val allowAccountsAccess: Boolean
    get() = true

}
