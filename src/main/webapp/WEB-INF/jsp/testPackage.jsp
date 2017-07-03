<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
	<div class="container text-center" id="tasksDiv">
		<div class="table-responsive">
			<table class="table table-striped table-bordered text-left table-hover">
				<thead>
					<tr class="info" id="tableHeading">
						<th>S.No</th>
						<th>Username</th>
						<th>Actual Amount</th>
						<th>Amount Paid</th>
						<th>Discount</th>
						<th>Remaining Test</th>
						<th>Start Date</th>
						<th>End Date</th>
						<th>Package Status</th>
					</tr>
				</thead>
				<tbody align="center">
					<c:forEach var="testPackage" items="${testPackageList}" varStatus="status">
						<tr>
							<td>${status.count}</td>
							<td>${testPackage.username}</td>
							<td>${testPackage.actualAmount}</td>
							<td>${testPackage.amountPaid}</td>
							<td>${testPackage.discount}</td>
							<td>${testPackage.noOfTest}</td>
							<td>${testPackage.startDate}</td>
							<td>${testPackage.endDate}</td>
							<td>${testPackage.packageStatus}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
