package net.breezeware.dynamo.shipping.ups.dto.pickup;

import lombok.Data;

/**
 * Response Dto to Persits the Charge Detail of the Current Pickup Request.
 */
@Data
public class ChargeDetail {
    /**
     * Charge Code Refers the general charge type (eg:A = ACCESSORIAL TYPE,B = BASE
     * CHARGE TYPE,S = SURCHARGE TYPE)
     */
    private String chargeCode;

    private String chargeDescription;

    private String chargeAmount;

    private String taxAmount;
}