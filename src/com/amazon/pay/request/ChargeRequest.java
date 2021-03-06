/**
 * Copyright 2016-2017 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.amazon.pay.request;

import com.amazon.pay.exceptions.AmazonClientException;
import com.amazon.pay.response.model.ProviderCredit;
import com.amazon.pay.types.AmazonReferenceIdType;
import com.amazon.pay.types.CurrencyCode;
import java.io.Serializable;
import java.util.List;

/**
 * Container for the parameters to the Capture operation.
 * For more information documentation, see
 * https://pay.amazon.com/documentation/
 */

public class ChargeRequest implements Serializable {

    //required parameters
    private String amazonReferenceId;
    private AmazonReferenceIdType type;
    private String chargeReferenceId;
    private String amount;
    private CurrencyCode currencyCode;
    private String transactionTimeout;
    private Boolean captureNow;
    private String chargeOrderId;
    private String storeName;
    private String customInformation;
    private String platformId;

    //optional parameters
    private String sellerNote;
    private String softDescriptor;
    private String mwsAuthToken;

    private Boolean inheritShippingAddress;

    private List<ProviderCredit> providerCredit;

    public Boolean getInheritShippingAddress() {
        return inheritShippingAddress;
    }

    /**
     * Sets the InheritShippingAddress in ChargeRequest
     *
     * @param  inheritShippingAddress
     *
     * @return ChargeRequest
     */
    public void setInheritShippingAddress(final Boolean inheritShippingAddress) {
        this.inheritShippingAddress = inheritShippingAddress;
    }


    /**
     * Sets the InheritShippingAddress in ChargeRequest
     * Deprecated since SDK 2.2.1
     *
     * @param  inheritShippingAddress
     *
     * @return ChargeRequest
     */
    @Deprecated
    public void setInheritShippingAddress(final String inheritShippingAddress) {
        setInheritShippingAddress(Boolean.parseBoolean(inheritShippingAddress));
    }


    /*
    * @param amazonAuthorizationId
    *               The authorization identifier that was generated by
    *               Amazon in the earlier call to Authorize or AuthorizeOnBillingAgreement.
    * @param captureReferenceId
    *               The identifier for this capture transaction that you specify.
    *               This identifier must be unique for all your capture transactions.
    * @param captureAmount
    *               The amount to capture in this transaction.
    * @return
    *           Container holding Capture operation parameters
    *
    */
    public ChargeRequest() {
    }


    /**
     * Sets the Amazon Order Reference ID / Amazon Billing Agreement ID
     *
     * @param amazonReferenceId
     *
     * @return updated ChargeRequest
     **/
    public ChargeRequest withAmazonReferenceId(final String amazonReferenceId) {
        if ((amazonReferenceId != null) && (amazonReferenceId.length() > 0)) {
            final String switchChar = amazonReferenceId;
            switch (switchChar.charAt(0)) {
                case 'P':
                case 'S':
                    type = AmazonReferenceIdType.ORDER_REFERENCE_ID;
                    this.amazonReferenceId = amazonReferenceId;
                    break;
                case 'B':
                case 'C':
                    type = AmazonReferenceIdType.BILLING_AGREEMENT_ID;
                    this.amazonReferenceId = amazonReferenceId;
                    break;
                default:
                    throw new AmazonClientException("Invalid Amazon Reference ID");
            }
        } else {
            throw new AmazonClientException(
                    "Amazon Reference ID is a required field and should be a Order Reference ID / Billing Agreement ID");
        }

        return this;
    }


    /**
     * Sets the amount in ChargeRequest
     *
     * @param amount
     *       Specified amount for charge request
     *
     * @return ChargeRequest
     */
    public ChargeRequest withAmount(final String amount){
        this.amount = amount;
        return this;
    }


    /**
     * Sets the currency code in ChargeRequest
     *
     * @param currencyCode
     *       Three-digit currency code. In ISO 4217 format.
     *
     * @return ChargeRequest
     */
    public ChargeRequest withCurrencyCode(final CurrencyCode currencyCode) {
        this.currencyCode = currencyCode;
        return this;
    }


    /**
     * Sets the authorization reference Id. This needs to be unique Id across all authorization requests
     *
     * @param  chargeReferenceId
     *       Unique referenceId
     *
     * @return ChargeRequest
     */
    public ChargeRequest withChargeReferenceId(final String chargeReferenceId) {
        this.chargeReferenceId = chargeReferenceId;
        return this;
    }


    /**
     * Sets the Seller Note, Seller Authorization Note for Amazon Order Reference ID / Amazon Billing Agreement ID
     *
     * @param  chargeNote
     *
     * @return ChargeRequest
     */
    public ChargeRequest withChargeNote(final String chargeNote) {
        this.sellerNote = chargeNote;
        return this;
    }


    /**
     * Sets the transaction timeout to ChargeRequest
     *
     * @param  transactionTimeout
     *
     * @return ChargeRequest
     */
    public ChargeRequest withTransactionTimeout(final String transactionTimeout) {
        this.transactionTimeout = transactionTimeout;
        return this;
    }


    /**
     * Sets the captureNow in ChargeRequest
     *
     * @param  captureNow
     *
     * @return ChargeRequest
     */
    public ChargeRequest withCaptureNow(final Boolean captureNow) {
        this.captureNow = captureNow;
        return this;
    }


    /**
     * Sets the InheritShippingAddress in ChargeRequest
     *
     * @param  inheritShippingAddress
     *
     * @return ChargeRequest
     */
    public ChargeRequest withInheritShippingAddress(final Boolean inheritShippingAddress) {
        this.inheritShippingAddress = inheritShippingAddress;
        return this;
    }


    /**
     * Sets the InheritShippingAddress in ChargeRequest
     * Deprecated since SDK 2.2.1
     *
     * @param  inheritShippingAddress
     *
     * @return ChargeRequest
     */
    @Deprecated
    public ChargeRequest withInheritShippingAddress(final String inheritShippingAddress) {
        return withInheritShippingAddress(Boolean.parseBoolean(inheritShippingAddress));
    }


    /**
     * Sets the chargeOrderId in ChargeRequest
     *
     * @param  chargeOrderId
     *
     * @return ChargeRequest
     */
    public ChargeRequest withChargeOrderId(final String chargeOrderId) {
        this.chargeOrderId = chargeOrderId;
        return this;
    }


    /**
     * Sets the storeName in ChargeRequest
     *
     * @param  storeName
     *
     * @return ChargeRequest
     */
    public ChargeRequest withStoreName(final String storeName) {
        this.storeName = storeName;
        return this;
    }


    /**
     * Sets the customInformation in ChargeRequest
     *
     * @param  customInformation
     *
     * @return ChargeRequest
     */
    public ChargeRequest withCustomInformation(final String customInformation) {
        this.customInformation = customInformation;
        return this;
    }


    /**
     * Sets the platformId in ChargeRequest
     *
     * @param  platformId
     *
     * @return ChargeRequest
     */
    public ChargeRequest withPlatformId(final String platformId) {
        this.platformId = platformId;
        return this;
    }


    /**
     * Sets the softDescriptor in ChargeRequest
     *
     * @param  softDescriptor
     *
     * @return ChargeRequest
     */
    public ChargeRequest withSoftDescriptor(final String softDescriptor) {
        this.softDescriptor = softDescriptor;
        return this;
    }


    /**
     * Sets the providerCredit in ChargeRequest
     *
     * @param providerCredit
     *
     * @return ChargeRequest
     */
    public ChargeRequest withProviderCreditDetails(final List<ProviderCredit> providerCredit) {
        this.providerCredit = providerCredit;
        return this;
    }


    /**
     * Sets the mwsAuthToken in ChargeRequest
     *
     * @param mwsAuthToken
     *
     * @return ChargeRequest
     */
    public ChargeRequest withMWSAuthToken(final String mwsAuthToken) {
        this.mwsAuthToken = mwsAuthToken;
        return this;
    }

    public String getAmazonReferenceId() {
        return amazonReferenceId;
    }

    public AmazonReferenceIdType getType() {
        return type;
    }

    public String getChargeReferenceId() {
        return chargeReferenceId;
    }

    public String getAmount() {
        return amount;
    }

    public CurrencyCode getCurrencyCode() {
        return currencyCode;
    }

    public String getTransactionTimeout() {
        return transactionTimeout;
    }

    public Boolean getCaptureNow() {
        return captureNow;
    }

    public String getChargeOrderId() {
        return chargeOrderId;
    }

    public String getStoreName() {
        return storeName;
    }

    public String getCustomInformation() {
        return customInformation;
    }

    public String getPlatformId() {
        return platformId;
    }

    public String getSellerNote() {
        return sellerNote;
    }

    public String getSoftDescriptor() {
        return softDescriptor;
    }

    public String getMwsAuthToken() {
        return mwsAuthToken;
    }

    public List<ProviderCredit> getProviderCredit() {
        return providerCredit;
    }

    @Override
    public String toString() {
        return "ChargeRequest{"
                + "amazonReferenceId=" + amazonReferenceId
                + ", type=" + type
                + ", chargeReferenceId=" + chargeReferenceId
                + ", amount=" + amount
                + ", currencyCode=" + currencyCode
                + ", transactionTimeout=" + transactionTimeout
                + ", captureNow=" + captureNow
                + ", chargeOrderId=" + chargeOrderId
                + ", storeName=" + storeName
                + ", customInformation=" + customInformation
                + ", platformId=" + platformId
                + ", sellerNote=" + sellerNote
                + ", softDescriptor=" + softDescriptor
                + ", mwsAuthToken=" + mwsAuthToken
                + ", inheritShippingAddress=" + inheritShippingAddress
                + ", providerCredit=" + providerCredit + '}';
    }


}
