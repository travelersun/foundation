package com.tianzhu.foundation.module.fnd.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * PER_SECURITY_PROFILES holds user definitions of security profiles
based on organizations, positions and payrolls that the system will
use to restrict access to specific records in the Oracle HRMS
database. Access to secure database objects in Oracle HRMS is
controlled by means of a security profile that is linked to an Oracle
ID associated with your responsibility. Currently, the secure
database objects are organizations, positions, payrolls and people.
If the VIEW_ALL_FLAG is set to Y, then no security restriction applies
and anyone using this security profile can see all objects within
their product type. If the VIEW_ALL_FLAG is set to N, then any
combination of organization, position and payroll security can apply.
The restrictions of the security profile will determine the list of
people who are visible to the user. Security profiles are used by the
Generate Secure User process to create specific data objects for each
Oracle ID and by the Security List Maintenance process to populate the
secure lists for organization, position, payroll and people.
 * </p>
 *
 * @author Maya
 * @since 2019-10-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("PER_SECURITY_PROFILES")
public class PerSecurityProfiles implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("SECURITY_PROFILE_ID")
    private Long securityProfileId;

    /**
     * Security profile name.
     */
    @TableField("SECURITY_PROFILE_NAME")
    private String securityProfileName;

    @TableField("PROFILE_TYPE")
    private String profileType;

    /**
     * Foreign key to HR_ORGANIZATION_UNITS.
     */
    @TableField("BUSINESS_GROUP_ID")
    private Long businessGroupId;

    /**
     * 
Foreign key to PER_ALL_POSITIONS.
     */
    @TableField("POSITION_ID")
    private Long positionId;

    /**
     * 
Foreign key to HR_ORGANIZATION_UNITS.
     */
    @TableField("ORGANIZATION_ID")
    private Long organizationId;

    /**
     * Foreign key to PER_POSITION_STRUCTURES.
     */
    @TableField("POSITION_STRUCTURE_ID")
    private Long positionStructureId;

    /**
     * Foreign key to PER_ORGANIZATION_STRUCTURES.
     */
    @TableField("ORGANIZATION_STRUCTURE_ID")
    private Long organizationStructureId;

    /**
     * Include top organization in hierarchy in access list (Y/N).
     */
    @TableField("INCLUDE_TOP_ORGANIZATION_FLAG")
    private String includeTopOrganizationFlag;

    /**
     * Include top position in hierarchy in access list ( Y/N).
     */
    @TableField("INCLUDE_TOP_POSITION_FLAG")
    private String includeTopPositionFlag;

    /**
     * Grant access to applicants (Y for all applicants, N for restricted access, X for no access)
     */
    @TableField("VIEW_ALL_APPLICANTS_FLAG")
    private String viewAllApplicantsFlag;

    /**
     * Grant access to employees (Y for all employees, N for restricted access, X for no access)
     */
    @TableField("VIEW_ALL_EMPLOYEES_FLAG")
    private String viewAllEmployeesFlag;

    /**
     * Grant unrestricted access to all data (Y/N).
     */
    @TableField("VIEW_ALL_FLAG")
    private String viewAllFlag;

    /**
     * Grant unrestricted access to all organizations ( Y/N).
     */
    @TableField("VIEW_ALL_ORGANIZATIONS_FLAG")
    private String viewAllOrganizationsFlag;

    /**
     * Grant unrestricted access to all payrolls (Y/N).
     */
    @TableField("VIEW_ALL_PAYROLLS_FLAG")
    private String viewAllPayrollsFlag;

    /**
     * Grant unrestricted access to all positions (Y/N).
     */
    @TableField("VIEW_ALL_POSITIONS_FLAG")
    private String viewAllPositionsFlag;

    /**
     * Include or exclude specific payrolls.
     */
    @TableField("INCLUDE_EXCLUDE_PAYROLL_FLAG")
    private String includeExcludePayrollFlag;

    /**
     * This column specifies whether people outside the security profile may be made visible to a person on an ad-hoc basis
     */
    @TableField("ALLOW_GRANTED_USERS_FLAG")
    private String allowGrantedUsersFlag;

    /**
     * Restrict the people that are visible to those within your supervisor hierarchy
     */
    @TableField("RESTRICT_BY_SUPERVISOR_FLAG")
    private String restrictBySupervisorFlag;

    /**
     * The number of levels to use for the supervisor hierarchy
     */
    @TableField("SUPERVISOR_LEVELS")
    private Integer supervisorLevels;

    /**
     * Only use primary assignments when building the supervisor hierarchy
     */
    @TableField("EXCLUDE_SECONDARY_ASGS_FLAG")
    private String excludeSecondaryAsgsFlag;

    /**
     * Exclude the current person from the list of visible people
     */
    @TableField("EXCLUDE_PERSON_FLAG")
    private String excludePersonFlag;

    /**
     * The person to use for the top level in the supervisor hierarchy, or to use for the exclude user flag (optional)
     */
    @TableField("NAMED_PERSON_ID")
    private Long namedPersonId;

    /**
     * Specifies if a custom restriction is to be used
     */
    @TableField("CUSTOM_RESTRICTION_FLAG")
    private String customRestrictionFlag;

    /**
     * Specifies if all business groups are included for global security profiles
     */
    @TableField("EXCLUDE_BUSINESS_GROUPS_FLAG")
    private String excludeBusinessGroupsFlag;

    /**
     * Stores the mode by which organizations are secured.
     */
    @TableField("ORG_SECURITY_MODE")
    private String orgSecurityMode;

    /**
     * view all contingent workers flag
     */
    @TableField("VIEW_ALL_CWK_FLAG")
    private String viewAllCwkFlag;

    /**
     * view all contacts flag
     */
    @TableField("VIEW_ALL_CONTACTS_FLAG")
    private String viewAllContactsFlag;

    /**
     * Restrict on an individual assignment basis.
     */
    @TableField("RESTRICT_ON_INDIVIDUAL_ASG")
    private String restrictOnIndividualAsg;

    /**
     * Indicates whether the top organization is statically defined (S)or whether it is used-based.(U) or exclusion (E)
     */
    @TableField("TOP_ORGANIZATION_METHOD")
    private String topOrganizationMethod;

    /**
     * Indicates whether the top position is statically defined or whether it is used-based.
     */
    @TableField("TOP_POSITION_METHOD")
    private String topPositionMethod;

    /**
     * view all candidates flag
     */
    @TableField("VIEW_ALL_CANDIDATES_FLAG")
    private String viewAllCandidatesFlag;

    /**
     * The sql fragment of the custom restriction
     */
    @TableField("RESTRICTION_TEXT")
    private String restrictionText;

    /**
     * Reporting user name for the ID set up by the DBA.
     */
    @TableField("REPORTING_ORACLE_USERNAME")
    private String reportingOracleUsername;

    @TableField("REQUEST_ID")
    private Long requestId;

    @TableField("PROGRAM_APPLICATION_ID")
    private Long programApplicationId;

    @TableField("PROGRAM_ID")
    private Long programId;

    @TableField("PROGRAM_UPDATE_DATE")
    private Date programUpdateDate;

    @TableField("LAST_UPDATE_DATE")
    private Date lastUpdateDate;

    @TableField("LAST_UPDATED_BY")
    private String lastUpdatedBy;

    @TableField("CREATED_BY")
    private String createdBy;

    @TableField("CREATION_DATE")
    private Date creationDate;


}
