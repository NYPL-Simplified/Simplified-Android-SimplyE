package org.nypl.simplified.simplye

import org.nypl.simplified.ui.catalog.CatalogConfigurationServiceType

/**
 * The catalog configuration service for the application.
 */

class SimplyECatalogConfigurationService : CatalogConfigurationServiceType {

  override val showSettingsTab: Boolean
    get() = true

  override val showHoldsTab: Boolean
    get() = true

  override val supportErrorReportEmailAddress: String
    get() = "simplyemigrationreports@nypl.org"

  override val supportErrorReportSubject: String
    get() = "[SimplyE error report]"
}
