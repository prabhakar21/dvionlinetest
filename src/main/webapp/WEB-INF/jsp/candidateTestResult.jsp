<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="container text-center" id="tasksDiv">
			<div class="table-responsive">
					<table class="table table-striped table-bordered text-left table-hover">
						<thead>
							<tr class="info" id="tableHeading">
								<th>S.No</th>
								<th>Candidate Name</th>
								<th>E-mail</th>
								<th>Paper set</th>
								<th>Total Count</th>
								<th>Answered Count</th>
								<th>UnAnswered Count</th>
								<th>Correct Answer Count</th>
								<th>Total Marks</th>
								<th>Result Date</th>
							</tr>
						</thead>
						<tbody align="center">
							<c:forEach var="result" items="${resultList}" varStatus="status">
								<tr>
									<td>${status.count}</td>
									<td>${result.candidateName}</td>
									<td>${result.email}</td>
									<td>${result.questionSet}</td>
									<td>${result.totalCount}</td>
									<td>${result.answeredCount}</td>
									<td>${result.unAnsweredCount}</td>
									<td>${result.correctAnswerCount}</td>
									<td>${result.totalMarks}</td>
									<td>${result.resultDate}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
