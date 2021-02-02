package com.bootathon.heyJam.services.Components;

import com.bootathon.heyJam.services.databaseServices.UserInstitutionRelation;
import com.bootathon.heyJam.services.databaseServices.UserProfile;
import com.bootathon.heyJam.services.databaseServices.UserUserRelation;

import java.sql.SQLException;
import java.util.ArrayList;

public class UserInstitutionParticipantsRow {
    private String institutionProfileUniqueName;
    private String userProfileUsernameParticipant;
    private String userProfileNameParticipant;
    private String userInstitutionRelationYearJoinedParticipant;
    private String userInstitutionRelationDepartmentParticipant;
    private String userProfileEmailParticipant;
    private int userUserFollowStatus;

    public UserInstitutionParticipantsRow(String institutionProfileUniqueName, String userProfileUsernameParticipant, String userProfileNameParticipant, String userInstitutionRelationYearJoinedParticipant, String userInstitutionRelationDepartmentParticipant, String userProfileEmailParticipant, int userUserFollowStatus) {
        this.institutionProfileUniqueName = institutionProfileUniqueName;
        this.userProfileUsernameParticipant = userProfileUsernameParticipant;
        this.userProfileNameParticipant = userProfileNameParticipant;
        this.userInstitutionRelationYearJoinedParticipant = userInstitutionRelationYearJoinedParticipant;
        this.userInstitutionRelationDepartmentParticipant = userInstitutionRelationDepartmentParticipant;
        this.userProfileEmailParticipant = userProfileEmailParticipant;
        this.userUserFollowStatus = userUserFollowStatus;
    }

    public String getInstitutionProfileUniqueName() {
        return institutionProfileUniqueName;
    }

    public void setInstitutionProfileUniqueName(String institutionProfileUniqueName) {
        this.institutionProfileUniqueName = institutionProfileUniqueName;
    }

    public String getUserProfileUsernameParticipant() {
        return userProfileUsernameParticipant;
    }

    public void setUserProfileUsernameParticipant(String userProfileUsernameParticipant) {
        this.userProfileUsernameParticipant = userProfileUsernameParticipant;
    }

    public String getUserProfileNameParticipant() {
        return userProfileNameParticipant;
    }

    public void setUserProfileNameParticipant(String userProfileNameParticipant) {
        this.userProfileNameParticipant = userProfileNameParticipant;
    }

    public String getUserInstitutionRelationYearJoinedParticipant() {
        return userInstitutionRelationYearJoinedParticipant;
    }

    public void setUserInstitutionRelationYearJoinedParticipant(String userInstitutionRelationYearJoinedParticipant) {
        this.userInstitutionRelationYearJoinedParticipant = userInstitutionRelationYearJoinedParticipant;
    }

    public String getUserInstitutionRelationDepartmentParticipant() {
        return userInstitutionRelationDepartmentParticipant;
    }

    public void setUserInstitutionRelationDepartmentParticipant(String userInstitutionRelationDepartmentParticipant) {
        this.userInstitutionRelationDepartmentParticipant = userInstitutionRelationDepartmentParticipant;
    }

    public String getUserProfileEmailParticipant() {
        return userProfileEmailParticipant;
    }

    public void setUserProfileEmailParticipant(String userProfileEmailParticipant) {
        this.userProfileEmailParticipant = userProfileEmailParticipant;
    }

    public int getUserUserFollowStatus() {
        return userUserFollowStatus;
    }

    public void setUserUserFollowStatus(int userUserFollowStatus) {
        this.userUserFollowStatus = userUserFollowStatus;
    }

    public static ArrayList<UserInstitutionParticipantsRow> userInstitutionParticipants(String userProfileUsername,String institutionProfileUniqueName) throws SQLException, ClassNotFoundException {
        ArrayList<UserInstitutionRelation> allParticipants = UserInstitutionRelation.getInstitutionParticipants(institutionProfileUniqueName);
        ArrayList<UserInstitutionParticipantsRow> participants = new ArrayList<>();
        for(UserInstitutionRelation individual: allParticipants){
            if(!individual.getUserProfileUsername().equals(userProfileUsername)){
                UserProfile profile = UserProfile.getUserProfile(individual.getUserProfileUsername());
                if(profile != null) {
                    String userProfileUsernameParticipant = individual.getUserProfileUsername();
                    String userProfileNameParticipant = profile.getUserProfile_Name();
                    String userInstitutionJoiningYearParticipants = individual.getUserInstitutionRelation_JoiningYear();
                    String userInstitutionEmailParticipant = profile.getUserProfile_Email();
                    String userInstitutionDepartment = individual.getUserInstitutionRelation_Department();
                    int userUserFollowStatus = UserUserRelation.userUserRelationFollowStatus(userProfileUsername,individual.getUserProfileUsername());
                    participants.add(new UserInstitutionParticipantsRow(
                            institutionProfileUniqueName,
                            userProfileUsernameParticipant,
                            userProfileNameParticipant,
                            userInstitutionJoiningYearParticipants,
                            userInstitutionEmailParticipant,
                            userInstitutionDepartment,
                            userUserFollowStatus)
                    );
                }

            }
        }
        return participants;
    }

}