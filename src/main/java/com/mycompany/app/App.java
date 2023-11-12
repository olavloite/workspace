/*----------------------------------------------------------------------------------------
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for license information.
 *---------------------------------------------------------------------------------------*/

package com.mycompany.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class App {
    public static void main(String[] args) throws Exception {
        Class.forName("org.postgresql.Driver");
        System.out.println("Hello Remote World!");

        try (Connection connection = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/test-db")) {
          try (ResultSet resultSet = connection
                .createStatement()
                .executeQuery(
                  "select 'The Cloud Spanner Emulator says \"Hello!\" at timestamp ' || current_timestamp::varchar")) {
            while (resultSet.next()) {
                System.out.println("Message: " + resultSet.getString(1));
            }
          }
        }
    }
}
