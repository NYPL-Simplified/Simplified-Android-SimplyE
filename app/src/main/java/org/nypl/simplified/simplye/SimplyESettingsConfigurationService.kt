package org.nypl.simplified.simplye

import org.nypl.simplified.ui.settings.SettingsConfigurationServiceType

/**
 * The settings configuration service for the application.
 */

class SimplyESettingsConfigurationService : SettingsConfigurationServiceType {
  override val allowAccountsRegistryAccess = true
  override val allowAccountsAccess: Boolean
    get() = true

  override val allowAccountsRegistryAccess: Boolean
    get() = true
}
