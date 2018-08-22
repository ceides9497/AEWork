
package com.tekvizion.tekeye.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.tekvizion.tekeye.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ListAutomatedTestCasesResponse_QNAME = new QName("http://ws.tekeye.tekvizion.com/", "listAutomatedTestCasesResponse");
    private final static QName _GetTestPlanDetailsResponse_QNAME = new QName("http://ws.tekeye.tekvizion.com/", "getTestPlanDetailsResponse");
    private final static QName _GetTestCaseDetailsResponse_QNAME = new QName("http://ws.tekeye.tekvizion.com/", "getTestCaseDetailsResponse");
    private final static QName _GetTestCaseDetails_QNAME = new QName("http://ws.tekeye.tekvizion.com/", "getTestCaseDetails");
    private final static QName _DeleteAllTestCaseAutomationScripts_QNAME = new QName("http://ws.tekeye.tekvizion.com/", "deleteAllTestCaseAutomationScripts");
    private final static QName _ListAutomatableTestPlansByCustomerAndStatus_QNAME = new QName("http://ws.tekeye.tekvizion.com/", "listAutomatableTestPlansByCustomerAndStatus");
    private final static QName _DeleteTestCaseAutomationScriptByName_QNAME = new QName("http://ws.tekeye.tekvizion.com/", "deleteTestCaseAutomationScriptByName");
    private final static QName _ListAllAutomatableStandardTestPlans_QNAME = new QName("http://ws.tekeye.tekvizion.com/", "listAllAutomatableStandardTestPlans");
    private final static QName _ListAutomationScriptsByTestplan_QNAME = new QName("http://ws.tekeye.tekvizion.com/", "listAutomationScriptsByTestplan");
    private final static QName _ListTestCaseAutomationScriptsByExtensionResponse_QNAME = new QName("http://ws.tekeye.tekvizion.com/", "listTestCaseAutomationScriptsByExtensionResponse");
    private final static QName _GetAutomationScriptByIdResponse_QNAME = new QName("http://ws.tekeye.tekvizion.com/", "getAutomationScriptByIdResponse");
    private final static QName _GetConfigurationsOfTestPlan_QNAME = new QName("http://ws.tekeye.tekvizion.com/", "getConfigurationsOfTestPlan");
    private final static QName _GetTestCaseAutomationScriptByName_QNAME = new QName("http://ws.tekeye.tekvizion.com/", "getTestCaseAutomationScriptByName");
    private final static QName _ListAutomatableTestcaseListByTestPlanResponse_QNAME = new QName("http://ws.tekeye.tekvizion.com/", "listAutomatableTestcaseListByTestPlanResponse");
    private final static QName _DeleteTestCaseAutomationScriptByNameResponse_QNAME = new QName("http://ws.tekeye.tekvizion.com/", "deleteTestCaseAutomationScriptByNameResponse");
    private final static QName _UploadMultipleAutomationScripts_QNAME = new QName("http://ws.tekeye.tekvizion.com/", "uploadMultipleAutomationScripts");
    private final static QName _ListAutomatedTestCasesByStatus_QNAME = new QName("http://ws.tekeye.tekvizion.com/", "listAutomatedTestCasesByStatus");
    private final static QName _ListAutomatableTestplans_QNAME = new QName("http://ws.tekeye.tekvizion.com/", "listAutomatableTestplans");
    private final static QName _ListAllTestCasesResponse_QNAME = new QName("http://ws.tekeye.tekvizion.com/", "listAllTestCasesResponse");
    private final static QName _ListAutomatableStandardTestPlansByStatus_QNAME = new QName("http://ws.tekeye.tekvizion.com/", "listAutomatableStandardTestPlansByStatus");
    private final static QName _ListAutomatableStandardTestPlansByStatusResponse_QNAME = new QName("http://ws.tekeye.tekvizion.com/", "listAutomatableStandardTestPlansByStatusResponse");
    private final static QName _DeleteAllTestCaseAutomationScriptsResponse_QNAME = new QName("http://ws.tekeye.tekvizion.com/", "deleteAllTestCaseAutomationScriptsResponse");
    private final static QName _GetAutomationScriptById_QNAME = new QName("http://ws.tekeye.tekvizion.com/", "getAutomationScriptById");
    private final static QName _ListAutomationScriptsByTestplanResponse_QNAME = new QName("http://ws.tekeye.tekvizion.com/", "listAutomationScriptsByTestplanResponse");
    private final static QName _ListAutomatableTestcaseListByTestPlan_QNAME = new QName("http://ws.tekeye.tekvizion.com/", "listAutomatableTestcaseListByTestPlan");
    private final static QName _DeleteAllTestCaseAutomationScriptsByExtension_QNAME = new QName("http://ws.tekeye.tekvizion.com/", "deleteAllTestCaseAutomationScriptsByExtension");
    private final static QName _GetLastModifiedDateOfTestPlanResponse_QNAME = new QName("http://ws.tekeye.tekvizion.com/", "getLastModifiedDateOfTestPlanResponse");
    private final static QName _ListAutomatableTestPlansByCustomerAndStatusResponse_QNAME = new QName("http://ws.tekeye.tekvizion.com/", "listAutomatableTestPlansByCustomerAndStatusResponse");
    private final static QName _UploadTestcaseAutomationScript_QNAME = new QName("http://ws.tekeye.tekvizion.com/", "uploadTestcaseAutomationScript");
    private final static QName _GetTestPlanDetails_QNAME = new QName("http://ws.tekeye.tekvizion.com/", "getTestPlanDetails");
    private final static QName _ListTestCaseAutomationScriptsByExtension_QNAME = new QName("http://ws.tekeye.tekvizion.com/", "listTestCaseAutomationScriptsByExtension");
    private final static QName _ListAllAutomatableStandardTestPlansResponse_QNAME = new QName("http://ws.tekeye.tekvizion.com/", "listAllAutomatableStandardTestPlansResponse");
    private final static QName _UploadTestcaseAutomationScriptResponse_QNAME = new QName("http://ws.tekeye.tekvizion.com/", "uploadTestcaseAutomationScriptResponse");
    private final static QName _GetConfigurationDetails_QNAME = new QName("http://ws.tekeye.tekvizion.com/", "getConfigurationDetails");
    private final static QName _GetLastModifiedDateOfTestCaseResponse_QNAME = new QName("http://ws.tekeye.tekvizion.com/", "getLastModifiedDateOfTestCaseResponse");
    private final static QName _ListAutomatableTestplansResponse_QNAME = new QName("http://ws.tekeye.tekvizion.com/", "listAutomatableTestplansResponse");
    private final static QName _DeleteAllTestCaseAutomationScriptsByExtensionResponse_QNAME = new QName("http://ws.tekeye.tekvizion.com/", "deleteAllTestCaseAutomationScriptsByExtensionResponse");
    private final static QName _ListAllTestCaseAutomationScriptsResponse_QNAME = new QName("http://ws.tekeye.tekvizion.com/", "listAllTestCaseAutomationScriptsResponse");
    private final static QName _DeleteAutomationScriptByIdResponse_QNAME = new QName("http://ws.tekeye.tekvizion.com/", "deleteAutomationScriptByIdResponse");
    private final static QName _ListAllTestCases_QNAME = new QName("http://ws.tekeye.tekvizion.com/", "listAllTestCases");
    private final static QName _ListAutomatedTestCasesByStatusResponse_QNAME = new QName("http://ws.tekeye.tekvizion.com/", "listAutomatedTestCasesByStatusResponse");
    private final static QName _GetConfigurationDetailsResponse_QNAME = new QName("http://ws.tekeye.tekvizion.com/", "getConfigurationDetailsResponse");
    private final static QName _GetLastModifiedDateOfTestPlan_QNAME = new QName("http://ws.tekeye.tekvizion.com/", "getLastModifiedDateOfTestPlan");
    private final static QName _GetLastModifiedDateOfTestCase_QNAME = new QName("http://ws.tekeye.tekvizion.com/", "getLastModifiedDateOfTestCase");
    private final static QName _UploadMultipleAutomationScriptsResponse_QNAME = new QName("http://ws.tekeye.tekvizion.com/", "uploadMultipleAutomationScriptsResponse");
    private final static QName _GetConfigurationsOfTestPlanResponse_QNAME = new QName("http://ws.tekeye.tekvizion.com/", "getConfigurationsOfTestPlanResponse");
    private final static QName _GetTestCaseAutomationScriptByNameResponse_QNAME = new QName("http://ws.tekeye.tekvizion.com/", "getTestCaseAutomationScriptByNameResponse");
    private final static QName _DeleteAutomationScriptById_QNAME = new QName("http://ws.tekeye.tekvizion.com/", "deleteAutomationScriptById");
    private final static QName _ListAllTestCaseAutomationScripts_QNAME = new QName("http://ws.tekeye.tekvizion.com/", "listAllTestCaseAutomationScripts");
    private final static QName _ListAutomatedTestCases_QNAME = new QName("http://ws.tekeye.tekvizion.com/", "listAutomatedTestCases");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.tekvizion.tekeye.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetLastModifiedDateOfTestPlanResponse }
     * 
     */
    public GetLastModifiedDateOfTestPlanResponse createGetLastModifiedDateOfTestPlanResponse() {
        return new GetLastModifiedDateOfTestPlanResponse();
    }

    /**
     * Create an instance of {@link DeleteAllTestCaseAutomationScriptsByExtension }
     * 
     */
    public DeleteAllTestCaseAutomationScriptsByExtension createDeleteAllTestCaseAutomationScriptsByExtension() {
        return new DeleteAllTestCaseAutomationScriptsByExtension();
    }

    /**
     * Create an instance of {@link ListAutomationScriptsByTestplanResponse }
     * 
     */
    public ListAutomationScriptsByTestplanResponse createListAutomationScriptsByTestplanResponse() {
        return new ListAutomationScriptsByTestplanResponse();
    }

    /**
     * Create an instance of {@link ListAutomatableTestcaseListByTestPlan }
     * 
     */
    public ListAutomatableTestcaseListByTestPlan createListAutomatableTestcaseListByTestPlan() {
        return new ListAutomatableTestcaseListByTestPlan();
    }

    /**
     * Create an instance of {@link DeleteAllTestCaseAutomationScriptsResponse }
     * 
     */
    public DeleteAllTestCaseAutomationScriptsResponse createDeleteAllTestCaseAutomationScriptsResponse() {
        return new DeleteAllTestCaseAutomationScriptsResponse();
    }

    /**
     * Create an instance of {@link GetAutomationScriptById }
     * 
     */
    public GetAutomationScriptById createGetAutomationScriptById() {
        return new GetAutomationScriptById();
    }

    /**
     * Create an instance of {@link ListAllTestCasesResponse }
     * 
     */
    public ListAllTestCasesResponse createListAllTestCasesResponse() {
        return new ListAllTestCasesResponse();
    }

    /**
     * Create an instance of {@link ListAutomatableTestplans }
     * 
     */
    public ListAutomatableTestplans createListAutomatableTestplans() {
        return new ListAutomatableTestplans();
    }

    /**
     * Create an instance of {@link ListAutomatableStandardTestPlansByStatus }
     * 
     */
    public ListAutomatableStandardTestPlansByStatus createListAutomatableStandardTestPlansByStatus() {
        return new ListAutomatableStandardTestPlansByStatus();
    }

    /**
     * Create an instance of {@link ListAutomatableStandardTestPlansByStatusResponse }
     * 
     */
    public ListAutomatableStandardTestPlansByStatusResponse createListAutomatableStandardTestPlansByStatusResponse() {
        return new ListAutomatableStandardTestPlansByStatusResponse();
    }

    /**
     * Create an instance of {@link UploadMultipleAutomationScripts }
     * 
     */
    public UploadMultipleAutomationScripts createUploadMultipleAutomationScripts() {
        return new UploadMultipleAutomationScripts();
    }

    /**
     * Create an instance of {@link ListAutomatedTestCasesByStatus }
     * 
     */
    public ListAutomatedTestCasesByStatus createListAutomatedTestCasesByStatus() {
        return new ListAutomatedTestCasesByStatus();
    }

    /**
     * Create an instance of {@link DeleteTestCaseAutomationScriptByNameResponse }
     * 
     */
    public DeleteTestCaseAutomationScriptByNameResponse createDeleteTestCaseAutomationScriptByNameResponse() {
        return new DeleteTestCaseAutomationScriptByNameResponse();
    }

    /**
     * Create an instance of {@link ListAutomatableTestcaseListByTestPlanResponse }
     * 
     */
    public ListAutomatableTestcaseListByTestPlanResponse createListAutomatableTestcaseListByTestPlanResponse() {
        return new ListAutomatableTestcaseListByTestPlanResponse();
    }

    /**
     * Create an instance of {@link GetTestCaseAutomationScriptByName }
     * 
     */
    public GetTestCaseAutomationScriptByName createGetTestCaseAutomationScriptByName() {
        return new GetTestCaseAutomationScriptByName();
    }

    /**
     * Create an instance of {@link GetConfigurationsOfTestPlan }
     * 
     */
    public GetConfigurationsOfTestPlan createGetConfigurationsOfTestPlan() {
        return new GetConfigurationsOfTestPlan();
    }

    /**
     * Create an instance of {@link ListTestCaseAutomationScriptsByExtensionResponse }
     * 
     */
    public ListTestCaseAutomationScriptsByExtensionResponse createListTestCaseAutomationScriptsByExtensionResponse() {
        return new ListTestCaseAutomationScriptsByExtensionResponse();
    }

    /**
     * Create an instance of {@link GetAutomationScriptByIdResponse }
     * 
     */
    public GetAutomationScriptByIdResponse createGetAutomationScriptByIdResponse() {
        return new GetAutomationScriptByIdResponse();
    }

    /**
     * Create an instance of {@link ListAutomationScriptsByTestplan }
     * 
     */
    public ListAutomationScriptsByTestplan createListAutomationScriptsByTestplan() {
        return new ListAutomationScriptsByTestplan();
    }

    /**
     * Create an instance of {@link DeleteTestCaseAutomationScriptByName }
     * 
     */
    public DeleteTestCaseAutomationScriptByName createDeleteTestCaseAutomationScriptByName() {
        return new DeleteTestCaseAutomationScriptByName();
    }

    /**
     * Create an instance of {@link ListAllAutomatableStandardTestPlans }
     * 
     */
    public ListAllAutomatableStandardTestPlans createListAllAutomatableStandardTestPlans() {
        return new ListAllAutomatableStandardTestPlans();
    }

    /**
     * Create an instance of {@link ListAutomatableTestPlansByCustomerAndStatus }
     * 
     */
    public ListAutomatableTestPlansByCustomerAndStatus createListAutomatableTestPlansByCustomerAndStatus() {
        return new ListAutomatableTestPlansByCustomerAndStatus();
    }

    /**
     * Create an instance of {@link GetTestCaseDetails }
     * 
     */
    public GetTestCaseDetails createGetTestCaseDetails() {
        return new GetTestCaseDetails();
    }

    /**
     * Create an instance of {@link DeleteAllTestCaseAutomationScripts }
     * 
     */
    public DeleteAllTestCaseAutomationScripts createDeleteAllTestCaseAutomationScripts() {
        return new DeleteAllTestCaseAutomationScripts();
    }

    /**
     * Create an instance of {@link GetTestCaseDetailsResponse }
     * 
     */
    public GetTestCaseDetailsResponse createGetTestCaseDetailsResponse() {
        return new GetTestCaseDetailsResponse();
    }

    /**
     * Create an instance of {@link GetTestPlanDetailsResponse }
     * 
     */
    public GetTestPlanDetailsResponse createGetTestPlanDetailsResponse() {
        return new GetTestPlanDetailsResponse();
    }

    /**
     * Create an instance of {@link ListAutomatedTestCasesResponse }
     * 
     */
    public ListAutomatedTestCasesResponse createListAutomatedTestCasesResponse() {
        return new ListAutomatedTestCasesResponse();
    }

    /**
     * Create an instance of {@link ListAllTestCaseAutomationScripts }
     * 
     */
    public ListAllTestCaseAutomationScripts createListAllTestCaseAutomationScripts() {
        return new ListAllTestCaseAutomationScripts();
    }

    /**
     * Create an instance of {@link ListAutomatedTestCases }
     * 
     */
    public ListAutomatedTestCases createListAutomatedTestCases() {
        return new ListAutomatedTestCases();
    }

    /**
     * Create an instance of {@link GetConfigurationsOfTestPlanResponse }
     * 
     */
    public GetConfigurationsOfTestPlanResponse createGetConfigurationsOfTestPlanResponse() {
        return new GetConfigurationsOfTestPlanResponse();
    }

    /**
     * Create an instance of {@link GetTestCaseAutomationScriptByNameResponse }
     * 
     */
    public GetTestCaseAutomationScriptByNameResponse createGetTestCaseAutomationScriptByNameResponse() {
        return new GetTestCaseAutomationScriptByNameResponse();
    }

    /**
     * Create an instance of {@link GetLastModifiedDateOfTestCase }
     * 
     */
    public GetLastModifiedDateOfTestCase createGetLastModifiedDateOfTestCase() {
        return new GetLastModifiedDateOfTestCase();
    }

    /**
     * Create an instance of {@link UploadMultipleAutomationScriptsResponse }
     * 
     */
    public UploadMultipleAutomationScriptsResponse createUploadMultipleAutomationScriptsResponse() {
        return new UploadMultipleAutomationScriptsResponse();
    }

    /**
     * Create an instance of {@link DeleteAutomationScriptById }
     * 
     */
    public DeleteAutomationScriptById createDeleteAutomationScriptById() {
        return new DeleteAutomationScriptById();
    }

    /**
     * Create an instance of {@link GetConfigurationDetailsResponse }
     * 
     */
    public GetConfigurationDetailsResponse createGetConfigurationDetailsResponse() {
        return new GetConfigurationDetailsResponse();
    }

    /**
     * Create an instance of {@link GetLastModifiedDateOfTestPlan }
     * 
     */
    public GetLastModifiedDateOfTestPlan createGetLastModifiedDateOfTestPlan() {
        return new GetLastModifiedDateOfTestPlan();
    }

    /**
     * Create an instance of {@link DeleteAutomationScriptByIdResponse }
     * 
     */
    public DeleteAutomationScriptByIdResponse createDeleteAutomationScriptByIdResponse() {
        return new DeleteAutomationScriptByIdResponse();
    }

    /**
     * Create an instance of {@link ListAllTestCases }
     * 
     */
    public ListAllTestCases createListAllTestCases() {
        return new ListAllTestCases();
    }

    /**
     * Create an instance of {@link ListAutomatedTestCasesByStatusResponse }
     * 
     */
    public ListAutomatedTestCasesByStatusResponse createListAutomatedTestCasesByStatusResponse() {
        return new ListAutomatedTestCasesByStatusResponse();
    }

    /**
     * Create an instance of {@link ListAllTestCaseAutomationScriptsResponse }
     * 
     */
    public ListAllTestCaseAutomationScriptsResponse createListAllTestCaseAutomationScriptsResponse() {
        return new ListAllTestCaseAutomationScriptsResponse();
    }

    /**
     * Create an instance of {@link DeleteAllTestCaseAutomationScriptsByExtensionResponse }
     * 
     */
    public DeleteAllTestCaseAutomationScriptsByExtensionResponse createDeleteAllTestCaseAutomationScriptsByExtensionResponse() {
        return new DeleteAllTestCaseAutomationScriptsByExtensionResponse();
    }

    /**
     * Create an instance of {@link GetConfigurationDetails }
     * 
     */
    public GetConfigurationDetails createGetConfigurationDetails() {
        return new GetConfigurationDetails();
    }

    /**
     * Create an instance of {@link GetLastModifiedDateOfTestCaseResponse }
     * 
     */
    public GetLastModifiedDateOfTestCaseResponse createGetLastModifiedDateOfTestCaseResponse() {
        return new GetLastModifiedDateOfTestCaseResponse();
    }

    /**
     * Create an instance of {@link ListAutomatableTestplansResponse }
     * 
     */
    public ListAutomatableTestplansResponse createListAutomatableTestplansResponse() {
        return new ListAutomatableTestplansResponse();
    }

    /**
     * Create an instance of {@link UploadTestcaseAutomationScriptResponse }
     * 
     */
    public UploadTestcaseAutomationScriptResponse createUploadTestcaseAutomationScriptResponse() {
        return new UploadTestcaseAutomationScriptResponse();
    }

    /**
     * Create an instance of {@link ListAllAutomatableStandardTestPlansResponse }
     * 
     */
    public ListAllAutomatableStandardTestPlansResponse createListAllAutomatableStandardTestPlansResponse() {
        return new ListAllAutomatableStandardTestPlansResponse();
    }

    /**
     * Create an instance of {@link GetTestPlanDetails }
     * 
     */
    public GetTestPlanDetails createGetTestPlanDetails() {
        return new GetTestPlanDetails();
    }

    /**
     * Create an instance of {@link ListTestCaseAutomationScriptsByExtension }
     * 
     */
    public ListTestCaseAutomationScriptsByExtension createListTestCaseAutomationScriptsByExtension() {
        return new ListTestCaseAutomationScriptsByExtension();
    }

    /**
     * Create an instance of {@link UploadTestcaseAutomationScript }
     * 
     */
    public UploadTestcaseAutomationScript createUploadTestcaseAutomationScript() {
        return new UploadTestcaseAutomationScript();
    }

    /**
     * Create an instance of {@link ListAutomatableTestPlansByCustomerAndStatusResponse }
     * 
     */
    public ListAutomatableTestPlansByCustomerAndStatusResponse createListAutomatableTestPlansByCustomerAndStatusResponse() {
        return new ListAutomatableTestPlansByCustomerAndStatusResponse();
    }

    /**
     * Create an instance of {@link WsAutomationScript }
     * 
     */
    public WsAutomationScript createWsAutomationScript() {
        return new WsAutomationScript();
    }

    /**
     * Create an instance of {@link WsTestCase }
     * 
     */
    public WsTestCase createWsTestCase() {
        return new WsTestCase();
    }

    /**
     * Create an instance of {@link WsTestPlan }
     * 
     */
    public WsTestPlan createWsTestPlan() {
        return new WsTestPlan();
    }

    /**
     * Create an instance of {@link WsConfiguration }
     * 
     */
    public WsConfiguration createWsConfiguration() {
        return new WsConfiguration();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListAutomatedTestCasesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.tekeye.tekvizion.com/", name = "listAutomatedTestCasesResponse")
    public JAXBElement<ListAutomatedTestCasesResponse> createListAutomatedTestCasesResponse(ListAutomatedTestCasesResponse value) {
        return new JAXBElement<ListAutomatedTestCasesResponse>(_ListAutomatedTestCasesResponse_QNAME, ListAutomatedTestCasesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTestPlanDetailsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.tekeye.tekvizion.com/", name = "getTestPlanDetailsResponse")
    public JAXBElement<GetTestPlanDetailsResponse> createGetTestPlanDetailsResponse(GetTestPlanDetailsResponse value) {
        return new JAXBElement<GetTestPlanDetailsResponse>(_GetTestPlanDetailsResponse_QNAME, GetTestPlanDetailsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTestCaseDetailsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.tekeye.tekvizion.com/", name = "getTestCaseDetailsResponse")
    public JAXBElement<GetTestCaseDetailsResponse> createGetTestCaseDetailsResponse(GetTestCaseDetailsResponse value) {
        return new JAXBElement<GetTestCaseDetailsResponse>(_GetTestCaseDetailsResponse_QNAME, GetTestCaseDetailsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTestCaseDetails }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.tekeye.tekvizion.com/", name = "getTestCaseDetails")
    public JAXBElement<GetTestCaseDetails> createGetTestCaseDetails(GetTestCaseDetails value) {
        return new JAXBElement<GetTestCaseDetails>(_GetTestCaseDetails_QNAME, GetTestCaseDetails.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteAllTestCaseAutomationScripts }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.tekeye.tekvizion.com/", name = "deleteAllTestCaseAutomationScripts")
    public JAXBElement<DeleteAllTestCaseAutomationScripts> createDeleteAllTestCaseAutomationScripts(DeleteAllTestCaseAutomationScripts value) {
        return new JAXBElement<DeleteAllTestCaseAutomationScripts>(_DeleteAllTestCaseAutomationScripts_QNAME, DeleteAllTestCaseAutomationScripts.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListAutomatableTestPlansByCustomerAndStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.tekeye.tekvizion.com/", name = "listAutomatableTestPlansByCustomerAndStatus")
    public JAXBElement<ListAutomatableTestPlansByCustomerAndStatus> createListAutomatableTestPlansByCustomerAndStatus(ListAutomatableTestPlansByCustomerAndStatus value) {
        return new JAXBElement<ListAutomatableTestPlansByCustomerAndStatus>(_ListAutomatableTestPlansByCustomerAndStatus_QNAME, ListAutomatableTestPlansByCustomerAndStatus.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteTestCaseAutomationScriptByName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.tekeye.tekvizion.com/", name = "deleteTestCaseAutomationScriptByName")
    public JAXBElement<DeleteTestCaseAutomationScriptByName> createDeleteTestCaseAutomationScriptByName(DeleteTestCaseAutomationScriptByName value) {
        return new JAXBElement<DeleteTestCaseAutomationScriptByName>(_DeleteTestCaseAutomationScriptByName_QNAME, DeleteTestCaseAutomationScriptByName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListAllAutomatableStandardTestPlans }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.tekeye.tekvizion.com/", name = "listAllAutomatableStandardTestPlans")
    public JAXBElement<ListAllAutomatableStandardTestPlans> createListAllAutomatableStandardTestPlans(ListAllAutomatableStandardTestPlans value) {
        return new JAXBElement<ListAllAutomatableStandardTestPlans>(_ListAllAutomatableStandardTestPlans_QNAME, ListAllAutomatableStandardTestPlans.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListAutomationScriptsByTestplan }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.tekeye.tekvizion.com/", name = "listAutomationScriptsByTestplan")
    public JAXBElement<ListAutomationScriptsByTestplan> createListAutomationScriptsByTestplan(ListAutomationScriptsByTestplan value) {
        return new JAXBElement<ListAutomationScriptsByTestplan>(_ListAutomationScriptsByTestplan_QNAME, ListAutomationScriptsByTestplan.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListTestCaseAutomationScriptsByExtensionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.tekeye.tekvizion.com/", name = "listTestCaseAutomationScriptsByExtensionResponse")
    public JAXBElement<ListTestCaseAutomationScriptsByExtensionResponse> createListTestCaseAutomationScriptsByExtensionResponse(ListTestCaseAutomationScriptsByExtensionResponse value) {
        return new JAXBElement<ListTestCaseAutomationScriptsByExtensionResponse>(_ListTestCaseAutomationScriptsByExtensionResponse_QNAME, ListTestCaseAutomationScriptsByExtensionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAutomationScriptByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.tekeye.tekvizion.com/", name = "getAutomationScriptByIdResponse")
    public JAXBElement<GetAutomationScriptByIdResponse> createGetAutomationScriptByIdResponse(GetAutomationScriptByIdResponse value) {
        return new JAXBElement<GetAutomationScriptByIdResponse>(_GetAutomationScriptByIdResponse_QNAME, GetAutomationScriptByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetConfigurationsOfTestPlan }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.tekeye.tekvizion.com/", name = "getConfigurationsOfTestPlan")
    public JAXBElement<GetConfigurationsOfTestPlan> createGetConfigurationsOfTestPlan(GetConfigurationsOfTestPlan value) {
        return new JAXBElement<GetConfigurationsOfTestPlan>(_GetConfigurationsOfTestPlan_QNAME, GetConfigurationsOfTestPlan.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTestCaseAutomationScriptByName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.tekeye.tekvizion.com/", name = "getTestCaseAutomationScriptByName")
    public JAXBElement<GetTestCaseAutomationScriptByName> createGetTestCaseAutomationScriptByName(GetTestCaseAutomationScriptByName value) {
        return new JAXBElement<GetTestCaseAutomationScriptByName>(_GetTestCaseAutomationScriptByName_QNAME, GetTestCaseAutomationScriptByName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListAutomatableTestcaseListByTestPlanResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.tekeye.tekvizion.com/", name = "listAutomatableTestcaseListByTestPlanResponse")
    public JAXBElement<ListAutomatableTestcaseListByTestPlanResponse> createListAutomatableTestcaseListByTestPlanResponse(ListAutomatableTestcaseListByTestPlanResponse value) {
        return new JAXBElement<ListAutomatableTestcaseListByTestPlanResponse>(_ListAutomatableTestcaseListByTestPlanResponse_QNAME, ListAutomatableTestcaseListByTestPlanResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteTestCaseAutomationScriptByNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.tekeye.tekvizion.com/", name = "deleteTestCaseAutomationScriptByNameResponse")
    public JAXBElement<DeleteTestCaseAutomationScriptByNameResponse> createDeleteTestCaseAutomationScriptByNameResponse(DeleteTestCaseAutomationScriptByNameResponse value) {
        return new JAXBElement<DeleteTestCaseAutomationScriptByNameResponse>(_DeleteTestCaseAutomationScriptByNameResponse_QNAME, DeleteTestCaseAutomationScriptByNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UploadMultipleAutomationScripts }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.tekeye.tekvizion.com/", name = "uploadMultipleAutomationScripts")
    public JAXBElement<UploadMultipleAutomationScripts> createUploadMultipleAutomationScripts(UploadMultipleAutomationScripts value) {
        return new JAXBElement<UploadMultipleAutomationScripts>(_UploadMultipleAutomationScripts_QNAME, UploadMultipleAutomationScripts.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListAutomatedTestCasesByStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.tekeye.tekvizion.com/", name = "listAutomatedTestCasesByStatus")
    public JAXBElement<ListAutomatedTestCasesByStatus> createListAutomatedTestCasesByStatus(ListAutomatedTestCasesByStatus value) {
        return new JAXBElement<ListAutomatedTestCasesByStatus>(_ListAutomatedTestCasesByStatus_QNAME, ListAutomatedTestCasesByStatus.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListAutomatableTestplans }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.tekeye.tekvizion.com/", name = "listAutomatableTestplans")
    public JAXBElement<ListAutomatableTestplans> createListAutomatableTestplans(ListAutomatableTestplans value) {
        return new JAXBElement<ListAutomatableTestplans>(_ListAutomatableTestplans_QNAME, ListAutomatableTestplans.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListAllTestCasesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.tekeye.tekvizion.com/", name = "listAllTestCasesResponse")
    public JAXBElement<ListAllTestCasesResponse> createListAllTestCasesResponse(ListAllTestCasesResponse value) {
        return new JAXBElement<ListAllTestCasesResponse>(_ListAllTestCasesResponse_QNAME, ListAllTestCasesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListAutomatableStandardTestPlansByStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.tekeye.tekvizion.com/", name = "listAutomatableStandardTestPlansByStatus")
    public JAXBElement<ListAutomatableStandardTestPlansByStatus> createListAutomatableStandardTestPlansByStatus(ListAutomatableStandardTestPlansByStatus value) {
        return new JAXBElement<ListAutomatableStandardTestPlansByStatus>(_ListAutomatableStandardTestPlansByStatus_QNAME, ListAutomatableStandardTestPlansByStatus.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListAutomatableStandardTestPlansByStatusResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.tekeye.tekvizion.com/", name = "listAutomatableStandardTestPlansByStatusResponse")
    public JAXBElement<ListAutomatableStandardTestPlansByStatusResponse> createListAutomatableStandardTestPlansByStatusResponse(ListAutomatableStandardTestPlansByStatusResponse value) {
        return new JAXBElement<ListAutomatableStandardTestPlansByStatusResponse>(_ListAutomatableStandardTestPlansByStatusResponse_QNAME, ListAutomatableStandardTestPlansByStatusResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteAllTestCaseAutomationScriptsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.tekeye.tekvizion.com/", name = "deleteAllTestCaseAutomationScriptsResponse")
    public JAXBElement<DeleteAllTestCaseAutomationScriptsResponse> createDeleteAllTestCaseAutomationScriptsResponse(DeleteAllTestCaseAutomationScriptsResponse value) {
        return new JAXBElement<DeleteAllTestCaseAutomationScriptsResponse>(_DeleteAllTestCaseAutomationScriptsResponse_QNAME, DeleteAllTestCaseAutomationScriptsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAutomationScriptById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.tekeye.tekvizion.com/", name = "getAutomationScriptById")
    public JAXBElement<GetAutomationScriptById> createGetAutomationScriptById(GetAutomationScriptById value) {
        return new JAXBElement<GetAutomationScriptById>(_GetAutomationScriptById_QNAME, GetAutomationScriptById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListAutomationScriptsByTestplanResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.tekeye.tekvizion.com/", name = "listAutomationScriptsByTestplanResponse")
    public JAXBElement<ListAutomationScriptsByTestplanResponse> createListAutomationScriptsByTestplanResponse(ListAutomationScriptsByTestplanResponse value) {
        return new JAXBElement<ListAutomationScriptsByTestplanResponse>(_ListAutomationScriptsByTestplanResponse_QNAME, ListAutomationScriptsByTestplanResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListAutomatableTestcaseListByTestPlan }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.tekeye.tekvizion.com/", name = "listAutomatableTestcaseListByTestPlan")
    public JAXBElement<ListAutomatableTestcaseListByTestPlan> createListAutomatableTestcaseListByTestPlan(ListAutomatableTestcaseListByTestPlan value) {
        return new JAXBElement<ListAutomatableTestcaseListByTestPlan>(_ListAutomatableTestcaseListByTestPlan_QNAME, ListAutomatableTestcaseListByTestPlan.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteAllTestCaseAutomationScriptsByExtension }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.tekeye.tekvizion.com/", name = "deleteAllTestCaseAutomationScriptsByExtension")
    public JAXBElement<DeleteAllTestCaseAutomationScriptsByExtension> createDeleteAllTestCaseAutomationScriptsByExtension(DeleteAllTestCaseAutomationScriptsByExtension value) {
        return new JAXBElement<DeleteAllTestCaseAutomationScriptsByExtension>(_DeleteAllTestCaseAutomationScriptsByExtension_QNAME, DeleteAllTestCaseAutomationScriptsByExtension.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLastModifiedDateOfTestPlanResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.tekeye.tekvizion.com/", name = "getLastModifiedDateOfTestPlanResponse")
    public JAXBElement<GetLastModifiedDateOfTestPlanResponse> createGetLastModifiedDateOfTestPlanResponse(GetLastModifiedDateOfTestPlanResponse value) {
        return new JAXBElement<GetLastModifiedDateOfTestPlanResponse>(_GetLastModifiedDateOfTestPlanResponse_QNAME, GetLastModifiedDateOfTestPlanResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListAutomatableTestPlansByCustomerAndStatusResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.tekeye.tekvizion.com/", name = "listAutomatableTestPlansByCustomerAndStatusResponse")
    public JAXBElement<ListAutomatableTestPlansByCustomerAndStatusResponse> createListAutomatableTestPlansByCustomerAndStatusResponse(ListAutomatableTestPlansByCustomerAndStatusResponse value) {
        return new JAXBElement<ListAutomatableTestPlansByCustomerAndStatusResponse>(_ListAutomatableTestPlansByCustomerAndStatusResponse_QNAME, ListAutomatableTestPlansByCustomerAndStatusResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UploadTestcaseAutomationScript }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.tekeye.tekvizion.com/", name = "uploadTestcaseAutomationScript")
    public JAXBElement<UploadTestcaseAutomationScript> createUploadTestcaseAutomationScript(UploadTestcaseAutomationScript value) {
        return new JAXBElement<UploadTestcaseAutomationScript>(_UploadTestcaseAutomationScript_QNAME, UploadTestcaseAutomationScript.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTestPlanDetails }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.tekeye.tekvizion.com/", name = "getTestPlanDetails")
    public JAXBElement<GetTestPlanDetails> createGetTestPlanDetails(GetTestPlanDetails value) {
        return new JAXBElement<GetTestPlanDetails>(_GetTestPlanDetails_QNAME, GetTestPlanDetails.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListTestCaseAutomationScriptsByExtension }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.tekeye.tekvizion.com/", name = "listTestCaseAutomationScriptsByExtension")
    public JAXBElement<ListTestCaseAutomationScriptsByExtension> createListTestCaseAutomationScriptsByExtension(ListTestCaseAutomationScriptsByExtension value) {
        return new JAXBElement<ListTestCaseAutomationScriptsByExtension>(_ListTestCaseAutomationScriptsByExtension_QNAME, ListTestCaseAutomationScriptsByExtension.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListAllAutomatableStandardTestPlansResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.tekeye.tekvizion.com/", name = "listAllAutomatableStandardTestPlansResponse")
    public JAXBElement<ListAllAutomatableStandardTestPlansResponse> createListAllAutomatableStandardTestPlansResponse(ListAllAutomatableStandardTestPlansResponse value) {
        return new JAXBElement<ListAllAutomatableStandardTestPlansResponse>(_ListAllAutomatableStandardTestPlansResponse_QNAME, ListAllAutomatableStandardTestPlansResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UploadTestcaseAutomationScriptResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.tekeye.tekvizion.com/", name = "uploadTestcaseAutomationScriptResponse")
    public JAXBElement<UploadTestcaseAutomationScriptResponse> createUploadTestcaseAutomationScriptResponse(UploadTestcaseAutomationScriptResponse value) {
        return new JAXBElement<UploadTestcaseAutomationScriptResponse>(_UploadTestcaseAutomationScriptResponse_QNAME, UploadTestcaseAutomationScriptResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetConfigurationDetails }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.tekeye.tekvizion.com/", name = "getConfigurationDetails")
    public JAXBElement<GetConfigurationDetails> createGetConfigurationDetails(GetConfigurationDetails value) {
        return new JAXBElement<GetConfigurationDetails>(_GetConfigurationDetails_QNAME, GetConfigurationDetails.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLastModifiedDateOfTestCaseResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.tekeye.tekvizion.com/", name = "getLastModifiedDateOfTestCaseResponse")
    public JAXBElement<GetLastModifiedDateOfTestCaseResponse> createGetLastModifiedDateOfTestCaseResponse(GetLastModifiedDateOfTestCaseResponse value) {
        return new JAXBElement<GetLastModifiedDateOfTestCaseResponse>(_GetLastModifiedDateOfTestCaseResponse_QNAME, GetLastModifiedDateOfTestCaseResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListAutomatableTestplansResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.tekeye.tekvizion.com/", name = "listAutomatableTestplansResponse")
    public JAXBElement<ListAutomatableTestplansResponse> createListAutomatableTestplansResponse(ListAutomatableTestplansResponse value) {
        return new JAXBElement<ListAutomatableTestplansResponse>(_ListAutomatableTestplansResponse_QNAME, ListAutomatableTestplansResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteAllTestCaseAutomationScriptsByExtensionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.tekeye.tekvizion.com/", name = "deleteAllTestCaseAutomationScriptsByExtensionResponse")
    public JAXBElement<DeleteAllTestCaseAutomationScriptsByExtensionResponse> createDeleteAllTestCaseAutomationScriptsByExtensionResponse(DeleteAllTestCaseAutomationScriptsByExtensionResponse value) {
        return new JAXBElement<DeleteAllTestCaseAutomationScriptsByExtensionResponse>(_DeleteAllTestCaseAutomationScriptsByExtensionResponse_QNAME, DeleteAllTestCaseAutomationScriptsByExtensionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListAllTestCaseAutomationScriptsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.tekeye.tekvizion.com/", name = "listAllTestCaseAutomationScriptsResponse")
    public JAXBElement<ListAllTestCaseAutomationScriptsResponse> createListAllTestCaseAutomationScriptsResponse(ListAllTestCaseAutomationScriptsResponse value) {
        return new JAXBElement<ListAllTestCaseAutomationScriptsResponse>(_ListAllTestCaseAutomationScriptsResponse_QNAME, ListAllTestCaseAutomationScriptsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteAutomationScriptByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.tekeye.tekvizion.com/", name = "deleteAutomationScriptByIdResponse")
    public JAXBElement<DeleteAutomationScriptByIdResponse> createDeleteAutomationScriptByIdResponse(DeleteAutomationScriptByIdResponse value) {
        return new JAXBElement<DeleteAutomationScriptByIdResponse>(_DeleteAutomationScriptByIdResponse_QNAME, DeleteAutomationScriptByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListAllTestCases }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.tekeye.tekvizion.com/", name = "listAllTestCases")
    public JAXBElement<ListAllTestCases> createListAllTestCases(ListAllTestCases value) {
        return new JAXBElement<ListAllTestCases>(_ListAllTestCases_QNAME, ListAllTestCases.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListAutomatedTestCasesByStatusResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.tekeye.tekvizion.com/", name = "listAutomatedTestCasesByStatusResponse")
    public JAXBElement<ListAutomatedTestCasesByStatusResponse> createListAutomatedTestCasesByStatusResponse(ListAutomatedTestCasesByStatusResponse value) {
        return new JAXBElement<ListAutomatedTestCasesByStatusResponse>(_ListAutomatedTestCasesByStatusResponse_QNAME, ListAutomatedTestCasesByStatusResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetConfigurationDetailsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.tekeye.tekvizion.com/", name = "getConfigurationDetailsResponse")
    public JAXBElement<GetConfigurationDetailsResponse> createGetConfigurationDetailsResponse(GetConfigurationDetailsResponse value) {
        return new JAXBElement<GetConfigurationDetailsResponse>(_GetConfigurationDetailsResponse_QNAME, GetConfigurationDetailsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLastModifiedDateOfTestPlan }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.tekeye.tekvizion.com/", name = "getLastModifiedDateOfTestPlan")
    public JAXBElement<GetLastModifiedDateOfTestPlan> createGetLastModifiedDateOfTestPlan(GetLastModifiedDateOfTestPlan value) {
        return new JAXBElement<GetLastModifiedDateOfTestPlan>(_GetLastModifiedDateOfTestPlan_QNAME, GetLastModifiedDateOfTestPlan.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLastModifiedDateOfTestCase }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.tekeye.tekvizion.com/", name = "getLastModifiedDateOfTestCase")
    public JAXBElement<GetLastModifiedDateOfTestCase> createGetLastModifiedDateOfTestCase(GetLastModifiedDateOfTestCase value) {
        return new JAXBElement<GetLastModifiedDateOfTestCase>(_GetLastModifiedDateOfTestCase_QNAME, GetLastModifiedDateOfTestCase.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UploadMultipleAutomationScriptsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.tekeye.tekvizion.com/", name = "uploadMultipleAutomationScriptsResponse")
    public JAXBElement<UploadMultipleAutomationScriptsResponse> createUploadMultipleAutomationScriptsResponse(UploadMultipleAutomationScriptsResponse value) {
        return new JAXBElement<UploadMultipleAutomationScriptsResponse>(_UploadMultipleAutomationScriptsResponse_QNAME, UploadMultipleAutomationScriptsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetConfigurationsOfTestPlanResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.tekeye.tekvizion.com/", name = "getConfigurationsOfTestPlanResponse")
    public JAXBElement<GetConfigurationsOfTestPlanResponse> createGetConfigurationsOfTestPlanResponse(GetConfigurationsOfTestPlanResponse value) {
        return new JAXBElement<GetConfigurationsOfTestPlanResponse>(_GetConfigurationsOfTestPlanResponse_QNAME, GetConfigurationsOfTestPlanResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTestCaseAutomationScriptByNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.tekeye.tekvizion.com/", name = "getTestCaseAutomationScriptByNameResponse")
    public JAXBElement<GetTestCaseAutomationScriptByNameResponse> createGetTestCaseAutomationScriptByNameResponse(GetTestCaseAutomationScriptByNameResponse value) {
        return new JAXBElement<GetTestCaseAutomationScriptByNameResponse>(_GetTestCaseAutomationScriptByNameResponse_QNAME, GetTestCaseAutomationScriptByNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteAutomationScriptById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.tekeye.tekvizion.com/", name = "deleteAutomationScriptById")
    public JAXBElement<DeleteAutomationScriptById> createDeleteAutomationScriptById(DeleteAutomationScriptById value) {
        return new JAXBElement<DeleteAutomationScriptById>(_DeleteAutomationScriptById_QNAME, DeleteAutomationScriptById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListAllTestCaseAutomationScripts }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.tekeye.tekvizion.com/", name = "listAllTestCaseAutomationScripts")
    public JAXBElement<ListAllTestCaseAutomationScripts> createListAllTestCaseAutomationScripts(ListAllTestCaseAutomationScripts value) {
        return new JAXBElement<ListAllTestCaseAutomationScripts>(_ListAllTestCaseAutomationScripts_QNAME, ListAllTestCaseAutomationScripts.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListAutomatedTestCases }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.tekeye.tekvizion.com/", name = "listAutomatedTestCases")
    public JAXBElement<ListAutomatedTestCases> createListAutomatedTestCases(ListAutomatedTestCases value) {
        return new JAXBElement<ListAutomatedTestCases>(_ListAutomatedTestCases_QNAME, ListAutomatedTestCases.class, null, value);
    }

}
