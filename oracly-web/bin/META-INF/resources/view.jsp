<%@ include file="/init.jsp" %>

<%  
List payableList = (List) renderRequest.getAttribute("payableList");
int payableCount = (int) renderRequest.getAttribute("payableCount"); 
PortletURL myPortletUrl = renderResponse.createRenderURL();
SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");


%>
<!--  link between two jsp pages without bothering to create an MVC Renderer - useful -->
<portlet:renderURL var="addPayable">
	<portlet:param name="jspPage" value="/create/addPayable.jsp" />
</portlet:renderURL>


<div style = "margin-left: 93%"><a href="${addPayable}"><span style="padding: 10px;" aria-hidden="true" class="icon-plus icon-2x"></a></span></div>

		<liferay-ui:search-container delta="10"
		 curParam="cur1"
		 deltaConfigurable="false"
		 iteratorURL="<%= myPortletUrl %>"
		 total="<%= payableCount %>"
		 id="projects" 
		 emptyResultsMessage="Sorry there are no projects are available">
		
			<aui:nav-bar cssClass="collapse-basic-search" markupView="lexicon">
					<aui:nav-bar-search>
						<aui:form action="<%= myPortletUrl.toString() %>" name="searchFm">
							<aui:input id="clickedField" name="clickedField" type="hidden" value="blank">
							</aui:input>					
							<liferay-ui:input-search markupView="lexicon" />
						</aui:form>
					</aui:nav-bar-search>
			</aui:nav-bar>
		
			<aui:form action="<%= myPortletUrl.toString() %>" id="filters" name="filters">
					<!-- JSTL iterator combined with a liferay aui taglib select will perform the filtering requirement -->  
					<!-- <aui:select id="projectCategory" name="projectCategory" label="Project Category">
									<c:forEach var="projectCategory" items="${projectCategory}">
										<aui:option value="${projectCategory}">${projectCategory}</aui:option>		
									</c:forEach>					
					</aui:select> -->
				</aui:form>
			<liferay-ui:search-container-results
				results="<%= payableList %>"
				
			/>
		
			<liferay-ui:search-container-row	
				className="com.liferay.oracly.accounts.payable.data.model.Payable"
				keyProperty="payableId"
				modelVar="payable"
			>
			
				<liferay-ui:search-container-column-text
					title="${payable.getSupplierName()}"
				    cssClass="col-md-4 flex-item-break-xs card-row-padded"
					name="Supplier"
					value="<%= payable.getSupplierName() %>"
				/>
				<liferay-ui:search-container-column-text
					name="Description"
					value="<%= payable.getDescription() %>"
				/>
				
				<liferay-ui:search-container-column-text
					name="Amount £"
					value="<%= payable.getAmount().toString() %>"
				/>
				
								
				<liferay-ui:search-container-column-text
					name="Due Date"
					value="<%= dateFormat.format(payable.getDueDate()).toString() %>"
				/>
				<liferay-ui:search-container-column-text
					name="Status">
					<c:choose>
			  			<c:when test="${payable.getFlag() != 0 }">	
			  				<span style="padding: 10px; color: red;" aria-hidden="true" class="icon-warning-sign"></span>
			  			</c:when>
						<c:otherwise>						
			  				<span style="padding: 10px;" aria-hidden="true" class="icon-thumbs-up"></span>			  				
						</c:otherwise>
					</c:choose>
				</liferay-ui:search-container-column-text>
				
				<liferay-ui:search-container-column-text name="Invoice"	>
					<a href="<%= payable.getPath() %>" target="blank"><span style="padding: 10px;" aria-hidden="true" class="icon-download"></span></a>
				</liferay-ui:search-container-column-text>
				
				
							
				</liferay-ui:search-container-row>		
				<liferay-ui:search-iterator markupView="lexicon"  />
			</liferay-ui:search-container>
	



