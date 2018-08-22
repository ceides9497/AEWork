
package com.tekvizion.tekeye.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsErrorCodes.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="wsErrorCodes">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="INVALID_TESTCASE_ID"/>
 *     &lt;enumeration value="TESTCASE_NOT_FOUND"/>
 *     &lt;enumeration value="INVALID_TESTPLAN_ID"/>
 *     &lt;enumeration value="TESTPLAN_NOT_FOUND"/>
 *     &lt;enumeration value="INVALID_SCRIPT_ID"/>
 *     &lt;enumeration value="SCRIPT_NOT_FOUND"/>
 *     &lt;enumeration value="INVALID_SCRIPT_FILE"/>
 *     &lt;enumeration value="SCRIPT_FILE_NAME_NOT_DEFINED"/>
 *     &lt;enumeration value="SCRIPT_FILE_EXTENSION_NOT_DEFINED"/>
 *     &lt;enumeration value="SCRIPT_FILE_SIZE_NOT_DEFINED"/>
 *     &lt;enumeration value="SCRIPT_FILE_CONTENT_TYPE_NOT_DEFINED"/>
 *     &lt;enumeration value="SCRIPT_FILE_SIZE_IS_ZERO"/>
 *     &lt;enumeration value="WSAUTOMATION_INSTANCE_IS_NULL"/>
 *     &lt;enumeration value="WSAUTOMATION_LIST_INSTANCE_IS_NULL"/>
 *     &lt;enumeration value="SCRIPT_FILE_IS_TOO_LARGE"/>
 *     &lt;enumeration value="INVALID_FILE_NAME"/>
 *     &lt;enumeration value="SUCCESS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "wsErrorCodes")
@XmlEnum
public enum WsErrorCodes {

    INVALID_TESTCASE_ID,
    TESTCASE_NOT_FOUND,
    INVALID_TESTPLAN_ID,
    TESTPLAN_NOT_FOUND,
    INVALID_SCRIPT_ID,
    SCRIPT_NOT_FOUND,
    INVALID_SCRIPT_FILE,
    SCRIPT_FILE_NAME_NOT_DEFINED,
    SCRIPT_FILE_EXTENSION_NOT_DEFINED,
    SCRIPT_FILE_SIZE_NOT_DEFINED,
    SCRIPT_FILE_CONTENT_TYPE_NOT_DEFINED,
    SCRIPT_FILE_SIZE_IS_ZERO,
    WSAUTOMATION_INSTANCE_IS_NULL,
    WSAUTOMATION_LIST_INSTANCE_IS_NULL,
    SCRIPT_FILE_IS_TOO_LARGE,
    INVALID_FILE_NAME,
    SUCCESS;

    public String value() {
        return name();
    }

    public static WsErrorCodes fromValue(String v) {
        return valueOf(v);
    }

}
