
package org.me.image;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para SearchbyCreaDate complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="SearchbyCreaDate">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="datacreacio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SearchbyCreaDate", propOrder = {
    "datacreacio"
})
public class SearchbyCreaDate {

    protected String datacreacio;

    /**
     * Obtiene el valor de la propiedad datacreacio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatacreacio() {
        return datacreacio;
    }

    /**
     * Define el valor de la propiedad datacreacio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatacreacio(String value) {
        this.datacreacio = value;
    }

}
