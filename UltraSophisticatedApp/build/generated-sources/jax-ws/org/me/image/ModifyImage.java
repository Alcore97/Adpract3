
package org.me.image;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ModifyImage complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ModifyImage">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="imatge" type="{http://image.me.org/}image" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ModifyImage", propOrder = {
    "imatge"
})
public class ModifyImage {

    protected Image imatge;

    /**
     * Obtiene el valor de la propiedad imatge.
     * 
     * @return
     *     possible object is
     *     {@link Image }
     *     
     */
    public Image getImatge() {
        return imatge;
    }

    /**
     * Define el valor de la propiedad imatge.
     * 
     * @param value
     *     allowed object is
     *     {@link Image }
     *     
     */
    public void setImatge(Image value) {
        this.imatge = value;
    }

}
