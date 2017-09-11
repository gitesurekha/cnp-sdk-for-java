//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.09.06 at 01:40:28 PM EDT 
//


package com.litle.sdk.generate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.litle.com/schema}transactionTypeWithReportGroup">
 *       &lt;sequence>
 *         &lt;element name="origId" type="{http://www.litle.com/schema}string25Type"/>
 *         &lt;element name="origActionType" type="{http://www.litle.com/schema}actionTypeEnum"/>
 *         &lt;element name="origLitleTxnId" type="{http://www.litle.com/schema}litleIdType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "origId",
    "origActionType",
    "origLitleTxnId"
})
public class QueryTransaction
    extends TransactionTypeWithReportGroup
{

    @XmlElement(required = true)
    protected String origId;
    @XmlElement(required = true)
    protected ActionTypeEnum origActionType;
    protected Long origLitleTxnId;

    /**
     * Gets the value of the origId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrigId() {
        return origId;
    }

    /**
     * Sets the value of the origId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrigId(String value) {
        this.origId = value;
    }

    /**
     * Gets the value of the origActionType property.
     * 
     * @return
     *     possible object is
     *     {@link ActionTypeEnum }
     *     
     */
    public ActionTypeEnum getOrigActionType() {
        return origActionType;
    }

    /**
     * Sets the value of the origActionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActionTypeEnum }
     *     
     */
    public void setOrigActionType(ActionTypeEnum value) {
        this.origActionType = value;
    }

    /**
     * Gets the value of the origLitleTxnId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOrigLitleTxnId() {
        return origLitleTxnId;
    }

    /**
     * Sets the value of the origLitleTxnId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOrigLitleTxnId(Long value) {
        this.origLitleTxnId = value;
    }

}