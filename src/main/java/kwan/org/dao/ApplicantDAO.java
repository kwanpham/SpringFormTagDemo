package kwan.org.dao;

import kwan.org.entity.Applicant;
import kwan.org.model.ApplicantInfo;

import java.util.List;


public interface ApplicantDAO {

    public Applicant findApplicant(String id);

    public List<ApplicantInfo> listApplicantInfos();

    public void saveApplicant(ApplicantInfo applicantInfo);

    public ApplicantInfo findApplicantInfo(String id);

    public void deleteApplicant(String id);

}