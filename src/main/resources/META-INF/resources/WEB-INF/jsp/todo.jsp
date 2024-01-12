
<%@ include file = "common/header.jspf" %>
<%@ include file = "common/navigation.jspf" %>

<div class = "container">
    <h1>Enter Todo Details </h1>
    <%-- Need modelAttribute to bind todo in the Controller addNewTodo method argument --%>
    <form:form method = "post" modelAttribute="todo">
        <fieldset class = "mb-3">
            <form:label path = "description">Description</form:label>
            <%-- Need path for binding Todo property description to the form field description --%>
            <form:input type = "text" path = "description" required="required"/>
            <%-- Show validation errors --%>
            <form:errors path = "description" cssClass = "text-warning"/>
        </fieldset>

        <fieldset class = "mb-3">
            <form:label path = "targetDate">Target Date</form:label>
            <%-- Need path for binding Todo property targetDate to the form field target Date --%>
            <form:input type = "text" path = "targetDate" required="required"/>
            <%-- Show validation errors --%>
            <form:errors path = "targetDate" cssClass = "text-warning"/>
        </fieldset>


        <%-- Hidden variables for id and done and set default values to avoid null pointer --%>
        <form:input type = "hidden" path = "id"/>
        <form:input type = "hidden" path = "done"/>
        <input type = "submit" class = "btn btn-success" />
    </form:form>
</div>

<%@ include file = "common/footer.jspf" %>


<script type="text/javascript">
    	$('#targetDate').datepicker({
    	    format: 'yyyy-mm-dd'
    	});
</script>