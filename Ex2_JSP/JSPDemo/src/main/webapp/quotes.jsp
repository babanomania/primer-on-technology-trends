<%@page import="org.apache.taglibs.standard.tag.common.core.ForEachSupport"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Set"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	
	<head>

		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<title>John Lennon Quotes</title>

		<script>
		
			var quotes = {
					<%
					
						Map<String, String> quotes = (Map<String, String>)request.getAttribute("quotes");
						Set<String> types = quotes.keySet();
						
						int counter=1;
						String sep = ",";
						
						for (String type : types) {
							
							if( counter == quotes.size() )
								sep = "";	
						
					%>
							<%= type %> : "<%= quotes.get(type)  %>" <%= sep %>
					<%
							counter++;
						}
					%>
					
			};

			function displayQuote(obj) {

			    var type = obj.options[ obj.selectedIndex ].value;
			    var selectedQuote = quotes[type];

			    document.getElementById("quote").innerHTML = selectedQuote;
			}

		</script>

		<style>
			.quote{
				color: #666666;
				font-size: 28px; 
				font-weight: 100 
				text-align:right; 
				padding-right: 30px;
				padding-top: 30px;
				padding-left: 30px;
				padding-bottom: 30px;
			}

		</style>

	</head>

	<body>

		<h1>John Lennon Quotes</h1>
		<hr/>

		<br/><br/>
		<span id="quote" class="quote"></span>
      	<br/><br/>

		 <select id="type" onChange="displayQuote(this);">
		 
		 	<%
		 		String[] alltypes = (String []) request.getAttribute("types");
		 		for (String atype : types) {
		 	%>
		 
		 		<option value="<%= atype %>"><%= atype %></option>
			
			<%	}	%>
			
		 </select> 

		 <script>

		 	var all_types = document.getElementById("type")
		 	displayQuote(all_types);

		 </script>

	<body>


</html>