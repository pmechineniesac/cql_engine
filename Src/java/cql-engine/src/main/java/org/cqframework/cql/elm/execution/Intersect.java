//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.04.12 at 08:52:42 PM MDT 
//


package org.cqframework.cql.elm.execution;

import org.cqframework.cql.execution.Context;
import org.jvnet.jaxb2_commons.lang.*;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.*;


/**
 * The Intersect operator returns the intersection of its arguments.
 * 			
 * This operator has two overloads:
 * 	List
 * 	Interval
 * 
 * For the list overload, this operator returns a list with the elements that appear in both lists, using equivalence semantics.
 * 
 * For the interval overload, this operator returns the interval that defines the overlapping portion of both arguments. If the arguments do not overlap, this operator returns null.
 * 
 * If either argument is null, the result is null.
 * 
 * <p>Java class for Intersect complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Intersect"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:hl7-org:elm:r1}BinaryExpression"&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Intersect", namespace = "urn:hl7-org:elm:r1")
public class Intersect
    extends BinaryExpression
    implements Equals, HashCode, ToString
{


    @Override
    public Intersect withOperand(Expression... values) {
        if (values!= null) {
            for (Expression value: values) {
                getOperand().add(value);
            }
        }
        return this;
    }

    @Override
    public Intersect withOperand(Collection<Expression> values) {
        if (values!= null) {
            getOperand().addAll(values);
        }
        return this;
    }

    @Override
    public Intersect withAnnotation(Object... values) {
        if (values!= null) {
            for (Object value: values) {
                getAnnotation().add(value);
            }
        }
        return this;
    }

    @Override
    public Intersect withAnnotation(Collection<Object> values) {
        if (values!= null) {
            getAnnotation().addAll(values);
        }
        return this;
    }

    @Override
    public Intersect withLocalId(String value) {
        setLocalId(value);
        return this;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof Intersect)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        return true;
    }

    public boolean equals(Object object) {
        final EqualsStrategy strategy = JAXBEqualsStrategy.INSTANCE;
        return equals(null, null, object, strategy);
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = super.hashCode(locator, strategy);
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

    public String toString() {
        final ToStringStrategy strategy = JAXBToStringStrategy.INSTANCE;
        final StringBuilder buffer = new StringBuilder();
        append(null, buffer, strategy);
        return buffer.toString();
    }

    public StringBuilder append(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
        strategy.appendStart(locator, this, buffer);
        appendFields(locator, buffer, strategy);
        strategy.appendEnd(locator, this, buffer);
        return buffer;
    }

    public StringBuilder appendFields(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
        super.appendFields(locator, buffer, strategy);
        return buffer;
    }

    @Override
    public Object evaluate(Context context) {
        Iterable<Object> left = (Iterable<Object>)getOperand().get(0).evaluate(context);
        Iterable<Object> right = (Iterable<Object>)getOperand().get(1).evaluate(context);

        if (left == null || right == null) {
            return null;
        }

        java.util.List<Object> result = new ArrayList<Object>();
        for (Object leftItem : left) {
            if (In.in(leftItem, right)) {
                result.add(leftItem);
            }
        }

        return result;
    }
}
