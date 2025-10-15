

@ApplicationModule(
  allowedDependencies = {
    "login::SaveUserLoginPort",
    "login::Login",
    "notification::UserRegisteredEvent",
    "common::*"}
)
package com.example.mymodulith.userregistration;

import org.springframework.modulith.ApplicationModule;
