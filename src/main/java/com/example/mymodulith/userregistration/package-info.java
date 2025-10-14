

@ApplicationModule(
  allowedDependencies = {
    "login::SaveUserLoginPort",
    "login::Login",
    "notification::NotificationService",
    "common::*"}
)
package com.example.mymodulith.userregistration;

import org.springframework.modulith.ApplicationModule;
