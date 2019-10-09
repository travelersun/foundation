package com.tianzhu.foundation.module.fnd.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * FND_PROFILE_OPTION_VALUES stores values for user profile options.
Each row includes values that identify the profile option, the
profile level, the user, responsibility, application or site for
whom the profile value is set (LEVEL_VALUE). Each row also include
the actual value for the option (always a CHAR string). If the
option is set for a responsibility, LEVEL_VALUE_APPLICATION_ID
identifies the application that has the responsibility. You need
one row for each profile option setting (at each level, for each
user, and so on). Oracle Application Object Library uses this
information to operate applications according to user profiles. 前端控制器
 * </p>
 *
 * @author Maya
 * @since 2019-10-09
 */
@RestController
@RequestMapping("/profileOptionValue")
public class FndProfileOptionValuesController {

}
