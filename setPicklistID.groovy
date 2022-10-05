JobRequisition?$select=cust_JobDescriptions,cust_CompanyProfileId/externalCode,cust_CompanyLogo/externalCode,cust_IsCompanyLogoVisibleInJobPostingSearch/externalCode,cust_companySectorId/externalCode,cust_IsHiddenJobPosting/externalCode,cust_referenceNumber,cust_JobPostingType/externalCode,cust_positionID/externalCode,cust_positionName,cust_jobAreaId/externalCode,cust_workingType/externalCode,cust_positionLevel/externalCode,cust_MonthlyNetIncome/externalCode,cust_IsMonthlyNetIncomeVisible/externalCode,cust_willBeCreateAtKariyerNet/externalCode,cust_kariyer,cust_WilluseKariyerlink/externalCode,cust_PositionCountryID/externalCode,cust_PositionDistrictId/externalCode,cust_PositionCityId/externalCode,cust_NumberOfPeopleToBeHired,cust_IsNumberOfPersonToBeHiredVisible/externalCode,cust_JobPostingTemplateId/externalCode,cust_JobPostingLanguageId/externalCode,cust_generalQualifications,cust_keyword,cust_EducationalStatus/externalCode,cust_PositionInThePastJobExperiencesId/externalCode,cust_SectorInThePastJobExperiencesId/externalCode,cust_MilitaryServiceStatus/externalCode,cust_Experience/externalCode,cust_MinimumYearsOfExperience,cust_MaximumYearsOfExperience,cust_DrivingLicence/externalCode,cust_LanguageId/externalCode,cust_LanguageReadingId/externalCode,cust_LanguageWritingId/externalCode,cust_LanguageSpeakingId/externalCode,cust_PublishDate,cust_PublishDay,cust_SpecifyAuthorizedUserOrNot/externalCode,cust_AuthorizedOrBlockedUserId/externalCode,cust_companyName/externalCode&$expand=cust_CompanyProfileId,cust_CompanyLogo,cust_IsCompanyLogoVisibleInJobPostingSearch,cust_companySectorId,cust_IsHiddenJobPosting,cust_JobPostingType,cust_positionID,cust_jobAreaId,cust_workingType,cust_positionLevel,cust_MonthlyNetIncome,cust_IsMonthlyNetIncomeVisible,cust_willBeCreateAtKariyerNet,cust_WilluseKariyerlink,cust_PositionCountryID,cust_PositionDistrictId,cust_PositionCityId,cust_IsNumberOfPersonToBeHiredVisible,cust_JobPostingTemplateId,cust_JobPostingLanguageId,cust_EducationalStatus,cust_PositionInThePastJobExperiencesId,cust_SectorInThePastJobExperiencesId,cust_MilitaryServiceStatus,cust_Experience,cust_DrivingLicence,cust_LanguageId,cust_LanguageReadingId,cust_LanguageWritingId,cust_LanguageSpeakingId,cust_SpecifyAuthorizedUserOrNot,cust_AuthorizedOrBlockedUserId,cust_companyName&$filter=lastModifiedDateTime gt datetimeoffset'2019-07-21T00:00:15Z' and cust_kariyer eq 'İlan Yaratma'
/*
 The integration developer needs to create the method processData 
 This method takes Message object of package com.sap.gateway.ip.core.customdev.util 
which includes helper methods useful for the content developer:
The methods available are:
    public java.lang.Object getBody()
	public void setBody(java.lang.Object exchangeBody)
    public java.util.Map<java.lang.String,java.lang.Object> getHeaders()
    public void setHeaders(java.util.Map<java.lang.String,java.lang.Object> exchangeHeaders)
    public void setHeader(java.lang.String name, java.lang.Object value)
    public java.util.Map<java.lang.String,java.lang.Object> getProperties()
    public void setProperties(java.util.Map<java.lang.String,java.lang.Object> exchangeProperties) 
       public void setProperty(java.lang.String name, java.lang.Object value)
 */


import com.sap.it.api.mapping.*;
import com.sap.gateway.ip.core.customdev.util.Message;
import java.util.HashMap;

def Message processData(Message message) {
       /*
    def messageLog = messageLogFactory.getMessageLog(message);    
    def xml = message.getBody(String.class);
    def completeXml= new XmlSlurper().parseText(xml);
    completeXml.LanguageId.each { message.setProperty("LanguageId", it.text()) }
    //def LanguageId = completeXml.CandidatesResponse.CandidatesResult.diffgram.NewDataSet.PersonalInformation.Language'**'.findAll{ node-> node.name() == 'LanguageId' }*.join(",") ;
    //message.setProperty("LanguageId", LanguageId);
    return message
    */
    def xml = message.getBody(String.class)
    def completeXml = new XmlSlurper().parseText(xml)
    
    def UniversityIds =completeXml.CandidatesResult.diffgram.NewDataSet.PersonalInformation.University.'**'.findAll{ node-> node.name() == 'UniversityId' }*.text()
    def Majors =completeXml.CandidatesResult.diffgram.NewDataSet.PersonalInformation.University.'**'.findAll{ node-> node.name() == 'UniversityTypeId' }*.text()
    def FacultyIds =completeXml.CandidatesResult.diffgram.NewDataSet.PersonalInformation.University.'**'.findAll{ node-> node.name() == 'FacultyId' }*.text()
    def DepartmentIds =completeXml.CandidatesResult.diffgram.NewDataSet.PersonalInformation.University.'**'.findAll{ node-> node.name() == 'DepartmentId' }*.text()
    def EducationTypes =completeXml.CandidatesResult.diffgram.NewDataSet.PersonalInformation.University.'**'.findAll{ node-> node.name() == 'EducationType' }*.text()
    def ScholarshipTypes =completeXml.CandidatesResult.diffgram.NewDataSet.PersonalInformation.University.'**'.findAll{ node-> node.name() == 'ScholarshipType' }*.text()
    def UniversityGraduationStatus =completeXml.CandidatesResult.diffgram.NewDataSet.PersonalInformation.University.'**'.findAll{ node-> node.name() == 'UniversityGraduationStatus' }*.text()
    def DoubleMajorFacultyIds =completeXml.CandidatesResult.diffgram.NewDataSet.PersonalInformation.University.'**'.findAll{ node-> node.name() == 'DoubleMajorFacultyId' }*.text()
    def DoubleMajorDepartmentIds =completeXml.CandidatesResult.diffgram.NewDataSet.PersonalInformation.University.'**'.findAll{ node-> node.name() == 'DoubleMajorDepartmentId' }*.text()
    def UniversityCityId =completeXml.CandidatesResult.diffgram.NewDataSet.PersonalInformation.University.'**'.findAll{ node-> node.name() == 'UniversityCityId' }*.text()
    def EducationLanguage =completeXml.CandidatesResult.diffgram.NewDataSet.PersonalInformation.University.'**'.findAll{ node-> node.name() == 'EducationLanguage' }*.text()
    
    
    
    
    def LanguageIds = completeXml.CandidatesResult.diffgram.NewDataSet.PersonalInformation.Language.'**'.findAll{ node-> node.name() == 'LanguageId' }*.text()
    def ReadingLevels = completeXml.CandidatesResult.diffgram.NewDataSet.PersonalInformation.Language.'**'.findAll{ node-> node.name() == 'ReadingLevel' }*.text()
    
    
    
    def HighSchoolStatus = completeXml.CandidatesResult.diffgram.NewDataSet.PersonalInformation.'**'.findAll{ node-> node.name() == 'GraduationStatus' }*.text()
    def HighSchoolDeparmentId = completeXml.CandidatesResult.diffgram.NewDataSet.PersonalInformation.'**'.findAll{ node-> node.name() == 'HighSchoolDeparmentId' }*.text()
    def HighSchoolTypeId = completeXml.CandidatesResult.diffgram.NewDataSet.PersonalInformation.'**'.findAll{ node-> node.name() == 'HighSchoolTypeId' }*.text()

    
    def HandicapPercentage = completeXml.CandidatesResult.diffgram.NewDataSet.PersonalInformation.'**'.findAll{ node-> node.name() == 'HandicapPercentage' }*.text()
    def HandicapCategory = completeXml.CandidatesResult.diffgram.NewDataSet.PersonalInformation.'**'.findAll{ node-> node.name() == 'HandicapCategory' }*.text()
    
    def DistrictId = completeXml.CandidatesResult.diffgram.NewDataSet.PersonalInformation.'**'.findAll{ node-> node.name() == 'DistrictId' }*.text()
    def CityId = completeXml.CandidatesResult.diffgram.NewDataSet.PersonalInformation.'**'.findAll{ node-> node.name() == 'CityId' }*.text()
    def CountryId = completeXml.CandidatesResult.diffgram.NewDataSet.PersonalInformation.'**'.findAll{ node-> node.name() == 'CountryId' }*.text()
    def Nationality = completeXml.CandidatesResult.diffgram.NewDataSet.PersonalInformation.'**'.findAll{ node-> node.name() == 'Nationality' }*.text()
    
    
    //def WorkingCityIds =completeXml.CandidatesResult.diffgram.NewDataSet.PersonalInformation.WorkExperience.'**'.findAll{ node-> node.name() == 'WorkingCityId' }*.text()
    def WorkingCountryIds =completeXml.CandidatesResult.diffgram.NewDataSet.PersonalInformation.WorkExperience.'**'.findAll{ node-> node.name() == 'WorkingCountryId' }*.text()
    //def SectorIds =completeXml.CandidatesResult.diffgram.NewDataSet.PersonalInformation.WorkExperience.'**'.findAll{ node-> node.name() == 'SectorId' }*.text()
    def WorkingTypes =completeXml.CandidatesResult.diffgram.NewDataSet.PersonalInformation.WorkExperience.'**'.findAll{ node-> node.name() == 'WorkingType' }*.text()
    //def LineOfBusinessIds =completeXml.CandidatesResult.diffgram.NewDataSet.PersonalInformation.WorkExperience.'**'.findAll{ node-> node.name() == 'LineOfBusinessId' }*.text()
    
    def ReferenceTypes =completeXml.CandidatesResult.diffgram.NewDataSet.PersonalInformation.Reference.'**'.findAll{ node-> node.name() == 'ReferenceType' }*.text()
    
        
    def referenceNumber =completeXml.CandidatesResult.diffgram.NewDataSet.PersonalInformation.JobApplication.'**'.findAll{ node-> node.name() == 'JobPostingId' }*.text()
    
     def DrivingLicenceClass =completeXml.CandidatesResult.diffgram.NewDataSet.PersonalInformation.'**'.findAll{ node-> node.name() == 'DrivingLicenceClass' }*.text()
     def PositionName =completeXml.CandidatesResult.diffgram.NewDataSet.PersonalInformation.WorkExperience.'**'.findAll{ node-> node.name() == 'PositionName' }*.text()
     
    
    message.setProperty("UniversityId", "picklist/picklistId eq 'cust_university' and externalCode eq '" + UniversityIds.join("' or picklist/picklistId eq 'cust_university' and externalCode eq '") + "'")
    message.setProperty("Major", "picklist/picklistId eq 'EducationType2' and externalCode eq '" + Majors.join("' or picklist/picklistId eq 'EducationType2' and externalCode eq '") + "'")
    //message.setProperty("FacultyId", "picklist/picklistId eq 'cust_faculty' and externalCode eq '" + FacultyIds.join("' or picklist/picklistId eq 'cust_faculty' and externalCode eq '") + "'")
    message.setProperty("DepartmentId", "picklist/picklistId eq 'cust_department' and externalCode eq '" + DepartmentIds.join("' or picklist/picklistId eq 'cust_department' and externalCode eq '") + "'")
    message.setProperty("EducationType", "picklist/picklistId eq 'EducationType2' and externalCode eq '" + EducationTypes.join("' or picklist/picklistId eq 'EducationType2' and externalCode eq '") + "'")
    //message.setProperty("ScholarshipType", "picklist/picklistId eq 'cust_bursTipi' and externalCode eq '" + ScholarshipTypes.join("' or picklist/picklistId eq 'cust_bursTipi' and externalCode eq '") + "'")
    message.setProperty("UniversityGraduationStatus", "picklist/picklistId eq 'EducationalStatus2' and externalCode eq '" + UniversityGraduationStatus.join("' or picklist/picklistId eq 'EducationalStatus2' and externalCode eq '") + "'")
    //message.setProperty("DoubleMajorFacultyId", "picklist/picklistId eq 'cust_faculty' and externalCode eq '" + DoubleMajorFacultyIds.join("' or picklist/picklistId eq 'cust_faculty' and externalCode eq '") + "'")
    message.setProperty("DoubleMajorDepartmentId", "picklist/picklistId eq 'cust_department' and externalCode eq '" + DoubleMajorDepartmentIds.join("' or picklist/picklistId eq 'cust_department' and externalCode eq '") + "'")
    message.setProperty("UniversityCityId", "picklist/picklistId eq 'cust_city3' and externalCode eq '" + UniversityCityId.join("' or picklist/picklistId eq 'cust_city3' and externalCode eq '") + "'")
    message.setProperty("EducationLanguage", "picklist/picklistId eq 'cust_LanguageId' and externalCode eq '" + EducationLanguage.join("' or picklist/picklistId eq 'cust_LanguageId' and externalCode eq '") + "'")
     
    message.setProperty("LanguageId", "picklist/picklistId eq 'cust_LanguageId' and externalCode eq '" + LanguageIds.join("' or picklist/picklistId eq 'cust_LanguageId' and externalCode eq '") + "'")
    //message.setProperty("ReadingLevel", "picklist/picklistId eq 'cust_languageLevel' and externalCode eq '" + ReadingLevels.join("' or picklist/picklistId eq 'cust_languageLevel' and externalCode eq '") + "'")
     
    //message.setProperty("HighSchoolStatus", "picklist/picklistId eq 'EduStatus' and externalCode eq '" + HighSchoolStatus.join("' or picklist/picklistId eq 'EduStatus' and externalCode eq '") + "'")
    message.setProperty("HighSchoolDeparmentId", "picklist/picklistId eq 'hdepart' and externalCode eq '" + HighSchoolDeparmentId.join("' or picklist/picklistId eq 'hdepart' and externalCode eq '") + "'")
    message.setProperty("HighSchoolTypeId", "picklist/picklistId eq 'htype' and externalCode eq '" + HighSchoolTypeId.join("' or picklist/picklistId eq 'htype' and externalCode eq '") + "'")
     
    message.setProperty("HandicapPercentage", "picklist/picklistId eq 'percDis' and externalCode eq '" + HandicapPercentage.join("' or picklist/picklistId eq 'percDis' and externalCode eq '") + "'")
    message.setProperty("HandicapCategory", "picklist/picklistId eq 'HandicapCategory' and externalCode eq '" + HandicapCategory.join("' or picklist/picklistId eq 'HandicapCategory' and externalCode eq '") + "'")
     
    message.setProperty("DistrictId", "picklist/picklistId eq 'cust_district2' and status eq 'ACTIVE' and externalCode eq '" + DistrictId.join("' or picklist/picklistId eq 'cust_district2' and status eq 'ACTIVE' and externalCode eq '") + "'")
    

     
     
     message.setProperty("CityId", "picklist/picklistId eq 'cust_city3' and externalCode eq '" + CityId.join("' or picklist/picklistId eq 'cust_city3' and externalCode eq '") + "'")
     
    message.setProperty("CountryId", "picklist/picklistId eq 'cust_country' and externalCode eq '" + CountryId.join("' or picklist/picklistId eq 'cust_country' and externalCode eq '") + "'")
    message.setProperty("Nationality", "picklist/picklistId eq 'country' and externalCode eq '" + Nationality.join("' or picklist/picklistId eq 'country' and externalCode eq '") + "'")
    
        
     //message.setProperty("WorkingCityId", "picklist/picklistId eq 'cust_city' and externalCode eq '" + WorkingCityIds.join("' or picklist/picklistId eq 'cust_city' and externalCode eq '") + "'")
     message.setProperty("WorkingCountryId", "picklist/picklistId eq 'cust_country' and externalCode eq '" + WorkingCountryIds.join("' or picklist/picklistId eq 'cust_country' and externalCode eq '") + "'")
     //message.setProperty("SectorId", "picklist/picklistId eq 'cust_sector' and externalCode eq '" + SectorIds.join("' or picklist/picklistId eq 'cust_sector' and externalCode eq '") + "'")
     message.setProperty("WorkingType", "picklist/picklistId eq 'WorkingType' and externalCode eq '" + WorkingTypes.join("' or picklist/picklistId eq 'WorkingType' and externalCode eq '") + "'")
     //message.setProperty("LineOfBusinessId", "picklist/picklistId eq 'cust_jobAreaId' and externalCode eq '" + LineOfBusinessIds.join("' or picklist/picklistId eq 'cust_jobAreaId' and externalCode eq '") + "'")
     
    message.setProperty("ReferenceType", "picklist/picklistId eq 'referansTipi' and externalCode eq '" + ReferenceTypes.join("' or picklist/picklistId eq 'referansTipi' and externalCode eq '") + "'")
    
    message.setProperty("referenceNumber", "cust_referenceNumber eq '" + referenceNumber.join("' or cust_referenceNumber eq '") + "'")
    message.setProperty("DrivingLicenceClass", "picklist/picklistId eq 'DrivingLicenceClass' and externalCode eq '" + DrivingLicenceClass.join("' or picklist/picklistId eq 'DrivingLicenceClass' and externalCode eq '") + "'")
  
    message.setProperty("PositionName", "picklist/picklistId eq 'positionkar' and externalCode eq '" + PositionName.join("' or picklist/picklistId eq 'positionkar' and externalCode eq '") + "'")
    
     message.setProperty("JobPostingId", "cust_referenceNumber eq '" + JobPostingId.join("' or cust_referenceNumber eq '") + "'")
    


     
     
     

    return message
}

