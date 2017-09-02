package com.iemr.helpline1097.service.co.beneficiarycall;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.iemr.helpline1097.data.co.beneficiarycall.BenCallServicesMappingHistory;
import com.iemr.helpline1097.data.co.beneficiarycall.SubServices;
import com.iemr.helpline1097.data.co.feedback.FeedbackDetails;
import com.iemr.helpline1097.data.co.services.CategoryDetails;
import com.iemr.helpline1097.data.co.services.DirectoryMapping;
import com.iemr.helpline1097.data.co.services.InstitutionDetails;
import com.iemr.helpline1097.data.co.services.SubCategoryDetails;
import com.iemr.helpline1097.repository.co.beneficiarycall.ServicesHistoryRepository;
import com.iemr.helpline1097.repository.co.services.InstitutionRepository;

@Service
public class ServicesHistoryServiceImpl implements ServicesHistoryService
{

	/**
	 * Service history repository
	 */
	private ServicesHistoryRepository serviceHistoryRepository;

	@Autowired
	public void setServiceHistoryRepository(ServicesHistoryRepository serviceHistoryRepository)
	{

		this.serviceHistoryRepository = serviceHistoryRepository;
	}

	private InstitutionRepository institutionRepository;

	@Autowired
	public void setInstitutionRepository(InstitutionRepository institutionRepository)
	{
		this.institutionRepository = institutionRepository;
	}

	@Override
	public BenCallServicesMappingHistory createServiceHistory(
			BenCallServicesMappingHistory benCallServicesMappingHistory)
	{

		return serviceHistoryRepository.save(benCallServicesMappingHistory);
	}

	@Override
	public List<BenCallServicesMappingHistory> getServiceHistory(Long id)
	{

		ArrayList<BenCallServicesMappingHistory> serviceHistoryList = new ArrayList<BenCallServicesMappingHistory>();
		List<Objects[]> lists = serviceHistoryRepository.findCallDetailsForBeneficiary(id);

		for (Object[] objects : lists)
		{
			if (objects != null && objects.length >= 19)
			{
				BenCallServicesMappingHistory call = new BenCallServicesMappingHistory((Long) objects[0],
						(Long) objects[1], (Long) objects[2], (Integer) objects[3], (SubServices) objects[4],
						(Integer) objects[5], (CategoryDetails) objects[6], (Integer) objects[7],
						(SubCategoryDetails) objects[8], (Long) objects[9], (FeedbackDetails) objects[10],
						(Long) objects[11], (DirectoryMapping) objects[12], (String) objects[13],
						(Timestamp) objects[14], (Integer) objects[15], (CategoryDetails) objects[16],
						(Integer) objects[17], (SubCategoryDetails) objects[18]);
				serviceHistoryList.add(call);
			}
		}
		return serviceHistoryList;
	}

	@Override
	public List<BenCallServicesMappingHistory> getCallSummary(Long id)
	{
		ArrayList<BenCallServicesMappingHistory> serviceHistoryList = new ArrayList<BenCallServicesMappingHistory>();
		List<Objects[]> lists = serviceHistoryRepository.getCallSummary(id);
		for (Object[] objects : lists)
		{
			if (objects != null && objects.length >= 19)
			{
				BenCallServicesMappingHistory srh = new BenCallServicesMappingHistory((Long) objects[0],
						(Long) objects[1], (Long) objects[2], (Integer) objects[3], (SubServices) objects[4],
						(Integer) objects[5], (CategoryDetails) objects[6], (Integer) objects[7],
						(SubCategoryDetails) objects[8], (Long) objects[9], (FeedbackDetails) objects[10],
						(Long) objects[11], (DirectoryMapping) objects[12], (String) objects[13],
						(Timestamp) objects[14], (Integer) objects[15], (CategoryDetails) objects[16],
						(Integer) objects[17], (SubCategoryDetails) objects[18]);
				serviceHistoryList.add(srh);
			}
		}
		return serviceHistoryList;
	}

	@Override
	public List<BenCallServicesMappingHistory> getReferralsHistory(Long id, int pageNo, int rows)
	{

		ArrayList<BenCallServicesMappingHistory> serviceHistoryList = new ArrayList<BenCallServicesMappingHistory>();
		List<Objects[]> lists = serviceHistoryRepository.findReferralsForBeneficiary(id, new PageRequest(pageNo, rows));

		for (Object[] objects : lists)
		{
			if (objects != null && objects.length >= 9)
			{
				BenCallServicesMappingHistory call = new BenCallServicesMappingHistory((Long) objects[0],
						(Long) objects[1], (Long) objects[2], (Integer) objects[3], (SubServices) objects[4],
						(Long) objects[5], (DirectoryMapping) objects[6], (String) objects[7], (Timestamp) objects[8]);
				serviceHistoryList.add(call);
			}
		}
		return serviceHistoryList;
	}

	@Override
	public List<BenCallServicesMappingHistory> getFeedbacksHistory(Long id, int pageNo, int rows)
	{

		ArrayList<BenCallServicesMappingHistory> serviceHistoryList = new ArrayList<BenCallServicesMappingHistory>();
		List<Objects[]> lists = serviceHistoryRepository.findFeedbacksForBeneficiary(id, new PageRequest(pageNo, rows));

		for (Object[] objects : lists)
		{
			if (objects != null && objects.length >= 9)
			{
				BenCallServicesMappingHistory call = new BenCallServicesMappingHistory((Long) objects[0],
						(Long) objects[1], (Long) objects[2], (Integer) objects[3], (SubServices) objects[4],
						(Long) objects[5], (FeedbackDetails) objects[6], (String) objects[7], (Timestamp) objects[8]);
				serviceHistoryList.add(call);
			}
		}
		return serviceHistoryList;
	}

	@Override
	public List<BenCallServicesMappingHistory> getInformationsHistory(Long id, int pageNo, int rows)
	{

		ArrayList<BenCallServicesMappingHistory> serviceHistoryList = new ArrayList<BenCallServicesMappingHistory>();
		List<Objects[]> lists = serviceHistoryRepository.findInformationsForBeneficiary(id,
				new PageRequest(pageNo, rows));

		for (Object[] objects : lists)
		{
			if (objects != null && objects.length >= 11)
			{
				BenCallServicesMappingHistory call = new BenCallServicesMappingHistory((Long) objects[0],
						(Long) objects[1], (Long) objects[2], (Integer) objects[3], (SubServices) objects[4],
						(Integer) objects[5], (CategoryDetails) objects[6], (Integer) objects[7],
						(SubCategoryDetails) objects[8], (String) objects[9], (Timestamp) objects[10]);
				serviceHistoryList.add(call);
			}
		}
		return serviceHistoryList;
	}

	@Override
	public List<BenCallServicesMappingHistory> getCounsellingsHistory(Long id, int pageNo, int rows)
	{

		ArrayList<BenCallServicesMappingHistory> serviceHistoryList = new ArrayList<BenCallServicesMappingHistory>();
		List<Objects[]> lists = serviceHistoryRepository.findCounsellingsForBeneficiary(id,
				new PageRequest(pageNo, rows));

		for (Object[] objects : lists)
		{
			if (objects != null && objects.length >= 11)
			{
				BenCallServicesMappingHistory call = new BenCallServicesMappingHistory((Long) objects[0],
						(Long) objects[1], (Long) objects[2], (Integer) objects[3], (SubServices) objects[4],
						(Integer) objects[5], (CategoryDetails) objects[6], (Integer) objects[7],
						(SubCategoryDetails) objects[8], (String) objects[9], (Timestamp) objects[10]);
				serviceHistoryList.add(call);
			}
		}
		return serviceHistoryList;
	}

}
