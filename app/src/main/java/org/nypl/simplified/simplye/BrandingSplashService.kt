package org.nypl.simplified.simplye

import org.nypl.simplified.branding.BrandingSplashServiceType

/**
 * A splash service for the SimplyE app.
 */

class BrandingSplashService : BrandingSplashServiceType {
  override fun splashImageResource(): Int {
    return R.drawable.simplified_splash
  }
}
