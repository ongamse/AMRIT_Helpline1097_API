package com.iemr.helpline1097.service.co.feedback;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.iemr.helpline1097.data.co.feedback.FeedbackDetails;

public interface FeedbackService
{

	public List<FeedbackDetails> getFeedbackRequests(long id);

	public List<FeedbackDetails> getFeedbackRequest(long id);

	public String updateFeedback(FeedbackDetails feedbackDetails);

	public FeedbackDetails createFeedback(FeedbackDetails feedbackDetails);

	// public String saveFeedbackFromCustomer(Iterable<FeedbackDetails> feedbackDetails);
	String saveFeedbackFromCustomer(String feedbackDetails, HttpServletRequest request) throws Exception;

}
