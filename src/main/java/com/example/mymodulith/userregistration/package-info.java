

@ApplicationModule(
  allowedDependencies = {
    "login::LoginService",
    "login::LoginDto",
    "notification::NotificationService",
    "common::*"}
)
package com.example.mymodulith.userregistration;

import org.springframework.modulith.ApplicationModule;
