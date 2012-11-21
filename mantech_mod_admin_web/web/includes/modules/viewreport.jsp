<%-- 
    Document   : viewreport
    Created on : Oct 29, 2012, 8:44:31 PM
    Author     : NGUYEN
--%>

<header><h3>Report</h3></header>
<form class="post_message" action="../ViewReportServlet" id="updateAccountForm" >
    <div class="message_list">
        <div class="module_content">
            <table>
                <tr>
                    <td><div class="message">Type of Report: 
                            <select name="type">
                                <option value="1">Category</option>
                                <option value="2">Department</option>
                                <option value="3">Details</option>
                                <option value="4">Technician</option>
                            </select>
                        </div></td>
                </tr>
            </table>
        </div>
    </div>
    <footer>
        <input type="submit"  value="Generate" class="alt_btn" />
    </footer>
</form>
