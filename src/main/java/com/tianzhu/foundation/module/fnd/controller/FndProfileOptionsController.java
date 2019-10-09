package com.tianzhu.foundation.module.fnd.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * FND_PROFILE_OPTIONS stores information about user profile options.
Each row includes names (the actual profile option name and the
more descriptive end-user name) and a description of the profile
option. Each row also includes the LOV definition, if any,
that this profile option uses to ensure that users enter a valid
value for the option, as well as flags that indicate whether users
can see or change its value and flags that indicate whether certain
Oracle Application Object Library routines can manipulate this
option. Each row also includes start and end dates, if any, for
this option. You need one row for each profile option (other than
internally generated profile options). Oracle Application Object
Library uses this information to generate user profiles. 前端控制器
 * </p>
 *
 * @author Maya
 * @since 2019-10-09
 */
@RestController
@RequestMapping("/profileOptions")
public class FndProfileOptionsController {

}
