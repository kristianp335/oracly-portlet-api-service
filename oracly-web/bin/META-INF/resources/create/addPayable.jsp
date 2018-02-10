<%@ include file="/init.jsp" %>

<% 
PortletURL myPortletUrl = renderResponse.createRenderURL();
SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
Date today = new Date();
int todayDay = today.getDate();
int todayMonth = today.getMonth();
int todayYear = today.getYear() + 1900;
%>

<portlet:actionURL var="savePayable"
	name="/save/savePayable">	
</portlet:actionURL>

<h2>Create Accounts Payable Record</h2>
<!-- task area -->

		<aui:form action="${savePayable}" name="fm" method="post" enctype="multipart/form-data" border="0">

		<aui:fieldset-group markupView="lexicon" border="0">			
		<div style="margin: 10px">	
			<aui:field-wrapper>	
				<label for="dueDate"><liferay-ui:message key="Ship to trade" /></label>	
				<liferay-ui:input-date dayParam="dueDay" monthParam="dueMonth" yearParam="dueYear"   name="dueDate" dayValue = "<%= todayDay %>"  monthValue = "<%= todayMonth %>" yearValue = "<%= todayYear %>"></liferay-ui:input-date>
			</aui:field-wrapper>
				<aui:field-wrapper required="true">
					
					<aui:input  type="file" name="invoice" required="true" label="Invoice"></aui:input>
					
				</aui:field-wrapper>
				
				<aui:field-wrapper required="true">
					
					<aui:input type="text" required="true" helpMessage="Please enter the amount of the invoice" id="amount" label="Amount" name="amount"></aui:input>
					
				</aui:field-wrapper>
				<aui:field-wrapper required="true">
				
					
					<aui:input type="textarea" required="true" helpMessage="Please enter a description for the invoice" id="description" label="Description" name="description"></aui:input>
					
				</aui:field-wrapper>
				
				<aui:field-wrapper required="true">
					
					<aui:input type="text" required="true" helpMessage="Enter the supplier name" id="supplier" label="Supplier name" name="supplier"></aui:input>
					
				</aui:field-wrapper>				
				<br/>
				<div id="<portlet:namespace />formSubmit" class="btn btn-primary" style="margin-bottom: 10px;">Add record</div>
			</div>
		</div>
		</aui:fieldset-group>
		</aui:form>
		
<script>
	$("#<portlet:namespace />formSubmit").on("click", function() {	
	$("#<portlet:namespace />fm").submit();
	});
</script>


