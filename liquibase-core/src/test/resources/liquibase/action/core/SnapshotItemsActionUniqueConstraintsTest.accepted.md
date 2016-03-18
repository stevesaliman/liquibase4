**NOTE: This output is generated and parsed by TestMD. Please read it, but DO NOT EDIT MANUALLY**

# Test: "Finds multi-column UQs correctly" #

- **connection:** generic standard

| Permutation | Verified | schema    | OPERATIONS
| :---------- | :------- | :-------- | :------
| 6e63508     | Generic  | LBSCHEMA  | **plan**: SELECT TC."CONSTRAINT_NAME", NULL AS TABLE_CATALOG, TC."TABLE_SCHEMA", TC."TABLE_NAME", NULL AS IS_DEFERRABLE, NULL AS INITIALLY_DEFERRED, KCU."COLUMN_NAME" FROM "INFORMATION_SCHEMA"."TABLE_CONSTRAINTS" TC JOIN "INFORMATION_SCHEMA"."KEY_COLUMN_USAGE" KCU ON TC.CONSTRAINT_NAME=KCU.CONSTRAINT_NAME AND TC.TABLE_SCHEMA=KCU.TABLE_SCHEMA AND TC.TABLE_NAME=KCU.TABLE_NAME WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA' AND TC.TABLE_NAME='TABLE_NAME' AND TC.CONSTRAINT_NAME='UQ_TEST'
| bbb8e61     | Generic  | LBSCHEMA2 | **plan**: SELECT TC."CONSTRAINT_NAME", NULL AS TABLE_CATALOG, TC."TABLE_SCHEMA", TC."TABLE_NAME", NULL AS IS_DEFERRABLE, NULL AS INITIALLY_DEFERRED, KCU."COLUMN_NAME" FROM "INFORMATION_SCHEMA"."TABLE_CONSTRAINTS" TC JOIN "INFORMATION_SCHEMA"."KEY_COLUMN_USAGE" KCU ON TC.CONSTRAINT_NAME=KCU.CONSTRAINT_NAME AND TC.TABLE_SCHEMA=KCU.TABLE_SCHEMA AND TC.TABLE_NAME=KCU.TABLE_NAME WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA2' AND TC.TABLE_NAME='TABLE_NAME' AND TC.CONSTRAINT_NAME='UQ_TEST'

# Test: "can find all uniqueConstraints in a fully qualified complex table name" #

- **connection:** generic standard

| Permutation | Verified | table                                   | OPERATIONS
| :---------- | :------- | :-------------------------------------- | :------
| 82ca36a     | Generic  | LBSCHEMA.4TEST_table                    | **plan**: SELECT TC."CONSTRAINT_NAME", NULL AS TABLE_CATALOG, TC."TABLE_SCHEMA", TC."TABLE_NAME", NULL AS IS_DEFERRABLE, NULL AS INITIALLY_DEFERRED, KCU."COLUMN_NAME" FROM "INFORMATION_SCHEMA"."TABLE_CONSTRAINTS" TC JOIN "INFORMATION_SCHEMA"."KEY_COLUMN_USAGE" KCU ON TC.CONSTRAINT_NAME=KCU.CONSTRAINT_NAME AND TC.TABLE_SCHEMA=KCU.TABLE_SCHEMA AND TC.TABLE_NAME=KCU.TABLE_NAME WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA' AND TC.TABLE_NAME='4TEST_table'
| a59cadd     | Generic  | LBSCHEMA.4test_table                    | **plan**: SELECT TC."CONSTRAINT_NAME", NULL AS TABLE_CATALOG, TC."TABLE_SCHEMA", TC."TABLE_NAME", NULL AS IS_DEFERRABLE, NULL AS INITIALLY_DEFERRED, KCU."COLUMN_NAME" FROM "INFORMATION_SCHEMA"."TABLE_CONSTRAINTS" TC JOIN "INFORMATION_SCHEMA"."KEY_COLUMN_USAGE" KCU ON TC.CONSTRAINT_NAME=KCU.CONSTRAINT_NAME AND TC.TABLE_SCHEMA=KCU.TABLE_SCHEMA AND TC.TABLE_NAME=KCU.TABLE_NAME WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA' AND TC.TABLE_NAME='4test_table'
| 02109bf     | Generic  | LBSCHEMA.ANOTHERUPPERTABLE              | **plan**: SELECT TC."CONSTRAINT_NAME", NULL AS TABLE_CATALOG, TC."TABLE_SCHEMA", TC."TABLE_NAME", NULL AS IS_DEFERRABLE, NULL AS INITIALLY_DEFERRED, KCU."COLUMN_NAME" FROM "INFORMATION_SCHEMA"."TABLE_CONSTRAINTS" TC JOIN "INFORMATION_SCHEMA"."KEY_COLUMN_USAGE" KCU ON TC.CONSTRAINT_NAME=KCU.CONSTRAINT_NAME AND TC.TABLE_SCHEMA=KCU.TABLE_SCHEMA AND TC.TABLE_NAME=KCU.TABLE_NAME WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA' AND TC.TABLE_NAME='ANOTHERUPPERTABLE'
| 0556eae     | Generic  | LBSCHEMA.AnotherMixedTable              | **plan**: SELECT TC."CONSTRAINT_NAME", NULL AS TABLE_CATALOG, TC."TABLE_SCHEMA", TC."TABLE_NAME", NULL AS IS_DEFERRABLE, NULL AS INITIALLY_DEFERRED, KCU."COLUMN_NAME" FROM "INFORMATION_SCHEMA"."TABLE_CONSTRAINTS" TC JOIN "INFORMATION_SCHEMA"."KEY_COLUMN_USAGE" KCU ON TC.CONSTRAINT_NAME=KCU.CONSTRAINT_NAME AND TC.TABLE_SCHEMA=KCU.TABLE_SCHEMA AND TC.TABLE_NAME=KCU.TABLE_NAME WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA' AND TC.TABLE_NAME='AnotherMixedTable'
| 2cbd26a     | Generic  | LBSCHEMA.CRAZY!@#\$%^&*()_+{}[]'"TABLE  | **plan**: SELECT TC."CONSTRAINT_NAME", NULL AS TABLE_CATALOG, TC."TABLE_SCHEMA", TC."TABLE_NAME", NULL AS IS_DEFERRABLE, NULL AS INITIALLY_DEFERRED, KCU."COLUMN_NAME" FROM "INFORMATION_SCHEMA"."TABLE_CONSTRAINTS" TC JOIN "INFORMATION_SCHEMA"."KEY_COLUMN_USAGE" KCU ON TC.CONSTRAINT_NAME=KCU.CONSTRAINT_NAME AND TC.TABLE_SCHEMA=KCU.TABLE_SCHEMA AND TC.TABLE_NAME=KCU.TABLE_NAME WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA' AND TC.TABLE_NAME='CRAZY!@#\$%^&*()_+{}[]''"TABLE'
| 6b38df5     | Generic  | LBSCHEMA.MixedTable                     | **plan**: SELECT TC."CONSTRAINT_NAME", NULL AS TABLE_CATALOG, TC."TABLE_SCHEMA", TC."TABLE_NAME", NULL AS IS_DEFERRABLE, NULL AS INITIALLY_DEFERRED, KCU."COLUMN_NAME" FROM "INFORMATION_SCHEMA"."TABLE_CONSTRAINTS" TC JOIN "INFORMATION_SCHEMA"."KEY_COLUMN_USAGE" KCU ON TC.CONSTRAINT_NAME=KCU.CONSTRAINT_NAME AND TC.TABLE_SCHEMA=KCU.TABLE_SCHEMA AND TC.TABLE_NAME=KCU.TABLE_NAME WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA' AND TC.TABLE_NAME='MixedTable'
| 7636549     | Generic  | LBSCHEMA.ONLY_IN_LBSCHEMA               | **plan**: SELECT TC."CONSTRAINT_NAME", NULL AS TABLE_CATALOG, TC."TABLE_SCHEMA", TC."TABLE_NAME", NULL AS IS_DEFERRABLE, NULL AS INITIALLY_DEFERRED, KCU."COLUMN_NAME" FROM "INFORMATION_SCHEMA"."TABLE_CONSTRAINTS" TC JOIN "INFORMATION_SCHEMA"."KEY_COLUMN_USAGE" KCU ON TC.CONSTRAINT_NAME=KCU.CONSTRAINT_NAME AND TC.TABLE_SCHEMA=KCU.TABLE_SCHEMA AND TC.TABLE_NAME=KCU.TABLE_NAME WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA' AND TC.TABLE_NAME='ONLY_IN_LBSCHEMA'
| 8f18146     | Generic  | LBSCHEMA.UPPERTABLE                     | **plan**: SELECT TC."CONSTRAINT_NAME", NULL AS TABLE_CATALOG, TC."TABLE_SCHEMA", TC."TABLE_NAME", NULL AS IS_DEFERRABLE, NULL AS INITIALLY_DEFERRED, KCU."COLUMN_NAME" FROM "INFORMATION_SCHEMA"."TABLE_CONSTRAINTS" TC JOIN "INFORMATION_SCHEMA"."KEY_COLUMN_USAGE" KCU ON TC.CONSTRAINT_NAME=KCU.CONSTRAINT_NAME AND TC.TABLE_SCHEMA=KCU.TABLE_SCHEMA AND TC.TABLE_NAME=KCU.TABLE_NAME WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA' AND TC.TABLE_NAME='UPPERTABLE'
| 5c86256     | Generic  | LBSCHEMA.anotherlowertable              | **plan**: SELECT TC."CONSTRAINT_NAME", NULL AS TABLE_CATALOG, TC."TABLE_SCHEMA", TC."TABLE_NAME", NULL AS IS_DEFERRABLE, NULL AS INITIALLY_DEFERRED, KCU."COLUMN_NAME" FROM "INFORMATION_SCHEMA"."TABLE_CONSTRAINTS" TC JOIN "INFORMATION_SCHEMA"."KEY_COLUMN_USAGE" KCU ON TC.CONSTRAINT_NAME=KCU.CONSTRAINT_NAME AND TC.TABLE_SCHEMA=KCU.TABLE_SCHEMA AND TC.TABLE_NAME=KCU.TABLE_NAME WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA' AND TC.TABLE_NAME='anotherlowertable'
| 86a5d18     | Generic  | LBSCHEMA.crazy!@#\$%^&*()_+{}[]'"table  | **plan**: SELECT TC."CONSTRAINT_NAME", NULL AS TABLE_CATALOG, TC."TABLE_SCHEMA", TC."TABLE_NAME", NULL AS IS_DEFERRABLE, NULL AS INITIALLY_DEFERRED, KCU."COLUMN_NAME" FROM "INFORMATION_SCHEMA"."TABLE_CONSTRAINTS" TC JOIN "INFORMATION_SCHEMA"."KEY_COLUMN_USAGE" KCU ON TC.CONSTRAINT_NAME=KCU.CONSTRAINT_NAME AND TC.TABLE_SCHEMA=KCU.TABLE_SCHEMA AND TC.TABLE_NAME=KCU.TABLE_NAME WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA' AND TC.TABLE_NAME='crazy!@#\$%^&*()_+{}[]''"table'
| c4dbeb3     | Generic  | LBSCHEMA.lowertable                     | **plan**: SELECT TC."CONSTRAINT_NAME", NULL AS TABLE_CATALOG, TC."TABLE_SCHEMA", TC."TABLE_NAME", NULL AS IS_DEFERRABLE, NULL AS INITIALLY_DEFERRED, KCU."COLUMN_NAME" FROM "INFORMATION_SCHEMA"."TABLE_CONSTRAINTS" TC JOIN "INFORMATION_SCHEMA"."KEY_COLUMN_USAGE" KCU ON TC.CONSTRAINT_NAME=KCU.CONSTRAINT_NAME AND TC.TABLE_SCHEMA=KCU.TABLE_SCHEMA AND TC.TABLE_NAME=KCU.TABLE_NAME WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA' AND TC.TABLE_NAME='lowertable'
| 31f94ac     | Generic  | LBSCHEMA2.4TEST_table                   | **plan**: SELECT TC."CONSTRAINT_NAME", NULL AS TABLE_CATALOG, TC."TABLE_SCHEMA", TC."TABLE_NAME", NULL AS IS_DEFERRABLE, NULL AS INITIALLY_DEFERRED, KCU."COLUMN_NAME" FROM "INFORMATION_SCHEMA"."TABLE_CONSTRAINTS" TC JOIN "INFORMATION_SCHEMA"."KEY_COLUMN_USAGE" KCU ON TC.CONSTRAINT_NAME=KCU.CONSTRAINT_NAME AND TC.TABLE_SCHEMA=KCU.TABLE_SCHEMA AND TC.TABLE_NAME=KCU.TABLE_NAME WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA2' AND TC.TABLE_NAME='4TEST_table'
| 13e76ef     | Generic  | LBSCHEMA2.4test_table                   | **plan**: SELECT TC."CONSTRAINT_NAME", NULL AS TABLE_CATALOG, TC."TABLE_SCHEMA", TC."TABLE_NAME", NULL AS IS_DEFERRABLE, NULL AS INITIALLY_DEFERRED, KCU."COLUMN_NAME" FROM "INFORMATION_SCHEMA"."TABLE_CONSTRAINTS" TC JOIN "INFORMATION_SCHEMA"."KEY_COLUMN_USAGE" KCU ON TC.CONSTRAINT_NAME=KCU.CONSTRAINT_NAME AND TC.TABLE_SCHEMA=KCU.TABLE_SCHEMA AND TC.TABLE_NAME=KCU.TABLE_NAME WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA2' AND TC.TABLE_NAME='4test_table'
| cec2e1c     | Generic  | LBSCHEMA2.ANOTHERUPPERTABLE             | **plan**: SELECT TC."CONSTRAINT_NAME", NULL AS TABLE_CATALOG, TC."TABLE_SCHEMA", TC."TABLE_NAME", NULL AS IS_DEFERRABLE, NULL AS INITIALLY_DEFERRED, KCU."COLUMN_NAME" FROM "INFORMATION_SCHEMA"."TABLE_CONSTRAINTS" TC JOIN "INFORMATION_SCHEMA"."KEY_COLUMN_USAGE" KCU ON TC.CONSTRAINT_NAME=KCU.CONSTRAINT_NAME AND TC.TABLE_SCHEMA=KCU.TABLE_SCHEMA AND TC.TABLE_NAME=KCU.TABLE_NAME WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA2' AND TC.TABLE_NAME='ANOTHERUPPERTABLE'
| fe461f7     | Generic  | LBSCHEMA2.AnotherMixedTable             | **plan**: SELECT TC."CONSTRAINT_NAME", NULL AS TABLE_CATALOG, TC."TABLE_SCHEMA", TC."TABLE_NAME", NULL AS IS_DEFERRABLE, NULL AS INITIALLY_DEFERRED, KCU."COLUMN_NAME" FROM "INFORMATION_SCHEMA"."TABLE_CONSTRAINTS" TC JOIN "INFORMATION_SCHEMA"."KEY_COLUMN_USAGE" KCU ON TC.CONSTRAINT_NAME=KCU.CONSTRAINT_NAME AND TC.TABLE_SCHEMA=KCU.TABLE_SCHEMA AND TC.TABLE_NAME=KCU.TABLE_NAME WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA2' AND TC.TABLE_NAME='AnotherMixedTable'
| dec400d     | Generic  | LBSCHEMA2.CRAZY!@#\$%^&*()_+{}[]'"TABLE | **plan**: SELECT TC."CONSTRAINT_NAME", NULL AS TABLE_CATALOG, TC."TABLE_SCHEMA", TC."TABLE_NAME", NULL AS IS_DEFERRABLE, NULL AS INITIALLY_DEFERRED, KCU."COLUMN_NAME" FROM "INFORMATION_SCHEMA"."TABLE_CONSTRAINTS" TC JOIN "INFORMATION_SCHEMA"."KEY_COLUMN_USAGE" KCU ON TC.CONSTRAINT_NAME=KCU.CONSTRAINT_NAME AND TC.TABLE_SCHEMA=KCU.TABLE_SCHEMA AND TC.TABLE_NAME=KCU.TABLE_NAME WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA2' AND TC.TABLE_NAME='CRAZY!@#\$%^&*()_+{}[]''"TABLE'
| cf72a30     | Generic  | LBSCHEMA2.MixedTable                    | **plan**: SELECT TC."CONSTRAINT_NAME", NULL AS TABLE_CATALOG, TC."TABLE_SCHEMA", TC."TABLE_NAME", NULL AS IS_DEFERRABLE, NULL AS INITIALLY_DEFERRED, KCU."COLUMN_NAME" FROM "INFORMATION_SCHEMA"."TABLE_CONSTRAINTS" TC JOIN "INFORMATION_SCHEMA"."KEY_COLUMN_USAGE" KCU ON TC.CONSTRAINT_NAME=KCU.CONSTRAINT_NAME AND TC.TABLE_SCHEMA=KCU.TABLE_SCHEMA AND TC.TABLE_NAME=KCU.TABLE_NAME WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA2' AND TC.TABLE_NAME='MixedTable'
| 6e579ae     | Generic  | LBSCHEMA2.ONLY_IN_LBSCHEMA2             | **plan**: SELECT TC."CONSTRAINT_NAME", NULL AS TABLE_CATALOG, TC."TABLE_SCHEMA", TC."TABLE_NAME", NULL AS IS_DEFERRABLE, NULL AS INITIALLY_DEFERRED, KCU."COLUMN_NAME" FROM "INFORMATION_SCHEMA"."TABLE_CONSTRAINTS" TC JOIN "INFORMATION_SCHEMA"."KEY_COLUMN_USAGE" KCU ON TC.CONSTRAINT_NAME=KCU.CONSTRAINT_NAME AND TC.TABLE_SCHEMA=KCU.TABLE_SCHEMA AND TC.TABLE_NAME=KCU.TABLE_NAME WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA2' AND TC.TABLE_NAME='ONLY_IN_LBSCHEMA2'
| d5eec30     | Generic  | LBSCHEMA2.UPPERTABLE                    | **plan**: SELECT TC."CONSTRAINT_NAME", NULL AS TABLE_CATALOG, TC."TABLE_SCHEMA", TC."TABLE_NAME", NULL AS IS_DEFERRABLE, NULL AS INITIALLY_DEFERRED, KCU."COLUMN_NAME" FROM "INFORMATION_SCHEMA"."TABLE_CONSTRAINTS" TC JOIN "INFORMATION_SCHEMA"."KEY_COLUMN_USAGE" KCU ON TC.CONSTRAINT_NAME=KCU.CONSTRAINT_NAME AND TC.TABLE_SCHEMA=KCU.TABLE_SCHEMA AND TC.TABLE_NAME=KCU.TABLE_NAME WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA2' AND TC.TABLE_NAME='UPPERTABLE'
| 00b229a     | Generic  | LBSCHEMA2.anotherlowertable             | **plan**: SELECT TC."CONSTRAINT_NAME", NULL AS TABLE_CATALOG, TC."TABLE_SCHEMA", TC."TABLE_NAME", NULL AS IS_DEFERRABLE, NULL AS INITIALLY_DEFERRED, KCU."COLUMN_NAME" FROM "INFORMATION_SCHEMA"."TABLE_CONSTRAINTS" TC JOIN "INFORMATION_SCHEMA"."KEY_COLUMN_USAGE" KCU ON TC.CONSTRAINT_NAME=KCU.CONSTRAINT_NAME AND TC.TABLE_SCHEMA=KCU.TABLE_SCHEMA AND TC.TABLE_NAME=KCU.TABLE_NAME WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA2' AND TC.TABLE_NAME='anotherlowertable'
| b875ac8     | Generic  | LBSCHEMA2.crazy!@#\$%^&*()_+{}[]'"table | **plan**: SELECT TC."CONSTRAINT_NAME", NULL AS TABLE_CATALOG, TC."TABLE_SCHEMA", TC."TABLE_NAME", NULL AS IS_DEFERRABLE, NULL AS INITIALLY_DEFERRED, KCU."COLUMN_NAME" FROM "INFORMATION_SCHEMA"."TABLE_CONSTRAINTS" TC JOIN "INFORMATION_SCHEMA"."KEY_COLUMN_USAGE" KCU ON TC.CONSTRAINT_NAME=KCU.CONSTRAINT_NAME AND TC.TABLE_SCHEMA=KCU.TABLE_SCHEMA AND TC.TABLE_NAME=KCU.TABLE_NAME WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA2' AND TC.TABLE_NAME='crazy!@#\$%^&*()_+{}[]''"table'
| 5921e4d     | Generic  | LBSCHEMA2.lowertable                    | **plan**: SELECT TC."CONSTRAINT_NAME", NULL AS TABLE_CATALOG, TC."TABLE_SCHEMA", TC."TABLE_NAME", NULL AS IS_DEFERRABLE, NULL AS INITIALLY_DEFERRED, KCU."COLUMN_NAME" FROM "INFORMATION_SCHEMA"."TABLE_CONSTRAINTS" TC JOIN "INFORMATION_SCHEMA"."KEY_COLUMN_USAGE" KCU ON TC.CONSTRAINT_NAME=KCU.CONSTRAINT_NAME AND TC.TABLE_SCHEMA=KCU.TABLE_SCHEMA AND TC.TABLE_NAME=KCU.TABLE_NAME WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA2' AND TC.TABLE_NAME='lowertable'

# Test: "can find all uniqueConstraints related to a schema" #

- **connection:** generic standard

| Permutation | Verified | schema    | OPERATIONS
| :---------- | :------- | :-------- | :------
| 6e63508     | Generic  | LBSCHEMA  | **plan**: SELECT TC."CONSTRAINT_NAME", NULL AS TABLE_CATALOG, TC."TABLE_SCHEMA", TC."TABLE_NAME", NULL AS IS_DEFERRABLE, NULL AS INITIALLY_DEFERRED, KCU."COLUMN_NAME" FROM "INFORMATION_SCHEMA"."TABLE_CONSTRAINTS" TC JOIN "INFORMATION_SCHEMA"."KEY_COLUMN_USAGE" KCU ON TC.CONSTRAINT_NAME=KCU.CONSTRAINT_NAME AND TC.TABLE_SCHEMA=KCU.TABLE_SCHEMA AND TC.TABLE_NAME=KCU.TABLE_NAME WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA'
| bbb8e61     | Generic  | LBSCHEMA2 | **plan**: SELECT TC."CONSTRAINT_NAME", NULL AS TABLE_CATALOG, TC."TABLE_SCHEMA", TC."TABLE_NAME", NULL AS IS_DEFERRABLE, NULL AS INITIALLY_DEFERRED, KCU."COLUMN_NAME" FROM "INFORMATION_SCHEMA"."TABLE_CONSTRAINTS" TC JOIN "INFORMATION_SCHEMA"."KEY_COLUMN_USAGE" KCU ON TC.CONSTRAINT_NAME=KCU.CONSTRAINT_NAME AND TC.TABLE_SCHEMA=KCU.TABLE_SCHEMA AND TC.TABLE_NAME=KCU.TABLE_NAME WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA2'

# Test: "can find all uniqueConstraints related to a table with a null name" #

- **connection:** generic standard

| Permutation | Verified | table             | OPERATIONS
| :---------- | :------- | :---------------- | :------
| e615770     | Generic  | LBSCHEMA.UNNAMED  | **plan**: SELECT TC."CONSTRAINT_NAME", NULL AS TABLE_CATALOG, TC."TABLE_SCHEMA", TC."TABLE_NAME", NULL AS IS_DEFERRABLE, NULL AS INITIALLY_DEFERRED, KCU."COLUMN_NAME" FROM "INFORMATION_SCHEMA"."TABLE_CONSTRAINTS" TC JOIN "INFORMATION_SCHEMA"."KEY_COLUMN_USAGE" KCU ON TC.CONSTRAINT_NAME=KCU.CONSTRAINT_NAME AND TC.TABLE_SCHEMA=KCU.TABLE_SCHEMA AND TC.TABLE_NAME=KCU.TABLE_NAME WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA'
| a649f3b     | Generic  | LBSCHEMA2.UNNAMED | **plan**: SELECT TC."CONSTRAINT_NAME", NULL AS TABLE_CATALOG, TC."TABLE_SCHEMA", TC."TABLE_NAME", NULL AS IS_DEFERRABLE, NULL AS INITIALLY_DEFERRED, KCU."COLUMN_NAME" FROM "INFORMATION_SCHEMA"."TABLE_CONSTRAINTS" TC JOIN "INFORMATION_SCHEMA"."KEY_COLUMN_USAGE" KCU ON TC.CONSTRAINT_NAME=KCU.CONSTRAINT_NAME AND TC.TABLE_SCHEMA=KCU.TABLE_SCHEMA AND TC.TABLE_NAME=KCU.TABLE_NAME WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA2'

# Test: "can find by UniqueConstraintReference with a table name but null constraint name" #

- **connection:** generic standard

| Permutation | Verified | uq                                                 | OPERATIONS
| :---------- | :------- | :------------------------------------------------- | :------
| ae9f06e     | Generic  | UNNAMED on LBSCHEMA.4TEST_table                    | **plan**: SELECT TC."CONSTRAINT_NAME", NULL AS TABLE_CATALOG, TC."TABLE_SCHEMA", TC."TABLE_NAME", NULL AS IS_DEFERRABLE, NULL AS INITIALLY_DEFERRED, KCU."COLUMN_NAME" FROM "INFORMATION_SCHEMA"."TABLE_CONSTRAINTS" TC JOIN "INFORMATION_SCHEMA"."KEY_COLUMN_USAGE" KCU ON TC.CONSTRAINT_NAME=KCU.CONSTRAINT_NAME AND TC.TABLE_SCHEMA=KCU.TABLE_SCHEMA AND TC.TABLE_NAME=KCU.TABLE_NAME WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA' AND TC.TABLE_NAME='4TEST_table'
| 7b86518     | Generic  | UNNAMED on LBSCHEMA.4test_table                    | **plan**: SELECT TC."CONSTRAINT_NAME", NULL AS TABLE_CATALOG, TC."TABLE_SCHEMA", TC."TABLE_NAME", NULL AS IS_DEFERRABLE, NULL AS INITIALLY_DEFERRED, KCU."COLUMN_NAME" FROM "INFORMATION_SCHEMA"."TABLE_CONSTRAINTS" TC JOIN "INFORMATION_SCHEMA"."KEY_COLUMN_USAGE" KCU ON TC.CONSTRAINT_NAME=KCU.CONSTRAINT_NAME AND TC.TABLE_SCHEMA=KCU.TABLE_SCHEMA AND TC.TABLE_NAME=KCU.TABLE_NAME WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA' AND TC.TABLE_NAME='4test_table'
| 5d7e9ab     | Generic  | UNNAMED on LBSCHEMA.ANOTHERUPPERTABLE              | **plan**: SELECT TC."CONSTRAINT_NAME", NULL AS TABLE_CATALOG, TC."TABLE_SCHEMA", TC."TABLE_NAME", NULL AS IS_DEFERRABLE, NULL AS INITIALLY_DEFERRED, KCU."COLUMN_NAME" FROM "INFORMATION_SCHEMA"."TABLE_CONSTRAINTS" TC JOIN "INFORMATION_SCHEMA"."KEY_COLUMN_USAGE" KCU ON TC.CONSTRAINT_NAME=KCU.CONSTRAINT_NAME AND TC.TABLE_SCHEMA=KCU.TABLE_SCHEMA AND TC.TABLE_NAME=KCU.TABLE_NAME WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA' AND TC.TABLE_NAME='ANOTHERUPPERTABLE'
| f02b463     | Generic  | UNNAMED on LBSCHEMA.AnotherMixedTable              | **plan**: SELECT TC."CONSTRAINT_NAME", NULL AS TABLE_CATALOG, TC."TABLE_SCHEMA", TC."TABLE_NAME", NULL AS IS_DEFERRABLE, NULL AS INITIALLY_DEFERRED, KCU."COLUMN_NAME" FROM "INFORMATION_SCHEMA"."TABLE_CONSTRAINTS" TC JOIN "INFORMATION_SCHEMA"."KEY_COLUMN_USAGE" KCU ON TC.CONSTRAINT_NAME=KCU.CONSTRAINT_NAME AND TC.TABLE_SCHEMA=KCU.TABLE_SCHEMA AND TC.TABLE_NAME=KCU.TABLE_NAME WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA' AND TC.TABLE_NAME='AnotherMixedTable'
| dec26ac     | Generic  | UNNAMED on LBSCHEMA.CRAZY!@#\$%^&*()_+{}[]'"TABLE  | **plan**: SELECT TC."CONSTRAINT_NAME", NULL AS TABLE_CATALOG, TC."TABLE_SCHEMA", TC."TABLE_NAME", NULL AS IS_DEFERRABLE, NULL AS INITIALLY_DEFERRED, KCU."COLUMN_NAME" FROM "INFORMATION_SCHEMA"."TABLE_CONSTRAINTS" TC JOIN "INFORMATION_SCHEMA"."KEY_COLUMN_USAGE" KCU ON TC.CONSTRAINT_NAME=KCU.CONSTRAINT_NAME AND TC.TABLE_SCHEMA=KCU.TABLE_SCHEMA AND TC.TABLE_NAME=KCU.TABLE_NAME WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA' AND TC.TABLE_NAME='CRAZY!@#\$%^&*()_+{}[]''"TABLE'
| 5af810d     | Generic  | UNNAMED on LBSCHEMA.MixedTable                     | **plan**: SELECT TC."CONSTRAINT_NAME", NULL AS TABLE_CATALOG, TC."TABLE_SCHEMA", TC."TABLE_NAME", NULL AS IS_DEFERRABLE, NULL AS INITIALLY_DEFERRED, KCU."COLUMN_NAME" FROM "INFORMATION_SCHEMA"."TABLE_CONSTRAINTS" TC JOIN "INFORMATION_SCHEMA"."KEY_COLUMN_USAGE" KCU ON TC.CONSTRAINT_NAME=KCU.CONSTRAINT_NAME AND TC.TABLE_SCHEMA=KCU.TABLE_SCHEMA AND TC.TABLE_NAME=KCU.TABLE_NAME WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA' AND TC.TABLE_NAME='MixedTable'
| 31888bc     | Generic  | UNNAMED on LBSCHEMA.ONLY_IN_LBSCHEMA               | **plan**: SELECT TC."CONSTRAINT_NAME", NULL AS TABLE_CATALOG, TC."TABLE_SCHEMA", TC."TABLE_NAME", NULL AS IS_DEFERRABLE, NULL AS INITIALLY_DEFERRED, KCU."COLUMN_NAME" FROM "INFORMATION_SCHEMA"."TABLE_CONSTRAINTS" TC JOIN "INFORMATION_SCHEMA"."KEY_COLUMN_USAGE" KCU ON TC.CONSTRAINT_NAME=KCU.CONSTRAINT_NAME AND TC.TABLE_SCHEMA=KCU.TABLE_SCHEMA AND TC.TABLE_NAME=KCU.TABLE_NAME WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA' AND TC.TABLE_NAME='ONLY_IN_LBSCHEMA'
| 92b5ebb     | Generic  | UNNAMED on LBSCHEMA.UPPERTABLE                     | **plan**: SELECT TC."CONSTRAINT_NAME", NULL AS TABLE_CATALOG, TC."TABLE_SCHEMA", TC."TABLE_NAME", NULL AS IS_DEFERRABLE, NULL AS INITIALLY_DEFERRED, KCU."COLUMN_NAME" FROM "INFORMATION_SCHEMA"."TABLE_CONSTRAINTS" TC JOIN "INFORMATION_SCHEMA"."KEY_COLUMN_USAGE" KCU ON TC.CONSTRAINT_NAME=KCU.CONSTRAINT_NAME AND TC.TABLE_SCHEMA=KCU.TABLE_SCHEMA AND TC.TABLE_NAME=KCU.TABLE_NAME WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA' AND TC.TABLE_NAME='UPPERTABLE'
| 12e4dd8     | Generic  | UNNAMED on LBSCHEMA.anotherlowertable              | **plan**: SELECT TC."CONSTRAINT_NAME", NULL AS TABLE_CATALOG, TC."TABLE_SCHEMA", TC."TABLE_NAME", NULL AS IS_DEFERRABLE, NULL AS INITIALLY_DEFERRED, KCU."COLUMN_NAME" FROM "INFORMATION_SCHEMA"."TABLE_CONSTRAINTS" TC JOIN "INFORMATION_SCHEMA"."KEY_COLUMN_USAGE" KCU ON TC.CONSTRAINT_NAME=KCU.CONSTRAINT_NAME AND TC.TABLE_SCHEMA=KCU.TABLE_SCHEMA AND TC.TABLE_NAME=KCU.TABLE_NAME WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA' AND TC.TABLE_NAME='anotherlowertable'
| 1d2bcfa     | Generic  | UNNAMED on LBSCHEMA.crazy!@#\$%^&*()_+{}[]'"table  | **plan**: SELECT TC."CONSTRAINT_NAME", NULL AS TABLE_CATALOG, TC."TABLE_SCHEMA", TC."TABLE_NAME", NULL AS IS_DEFERRABLE, NULL AS INITIALLY_DEFERRED, KCU."COLUMN_NAME" FROM "INFORMATION_SCHEMA"."TABLE_CONSTRAINTS" TC JOIN "INFORMATION_SCHEMA"."KEY_COLUMN_USAGE" KCU ON TC.CONSTRAINT_NAME=KCU.CONSTRAINT_NAME AND TC.TABLE_SCHEMA=KCU.TABLE_SCHEMA AND TC.TABLE_NAME=KCU.TABLE_NAME WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA' AND TC.TABLE_NAME='crazy!@#\$%^&*()_+{}[]''"table'
| 04425fc     | Generic  | UNNAMED on LBSCHEMA.lowertable                     | **plan**: SELECT TC."CONSTRAINT_NAME", NULL AS TABLE_CATALOG, TC."TABLE_SCHEMA", TC."TABLE_NAME", NULL AS IS_DEFERRABLE, NULL AS INITIALLY_DEFERRED, KCU."COLUMN_NAME" FROM "INFORMATION_SCHEMA"."TABLE_CONSTRAINTS" TC JOIN "INFORMATION_SCHEMA"."KEY_COLUMN_USAGE" KCU ON TC.CONSTRAINT_NAME=KCU.CONSTRAINT_NAME AND TC.TABLE_SCHEMA=KCU.TABLE_SCHEMA AND TC.TABLE_NAME=KCU.TABLE_NAME WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA' AND TC.TABLE_NAME='lowertable'
| fe632d2     | Generic  | UNNAMED on LBSCHEMA2.4TEST_table                   | **plan**: SELECT TC."CONSTRAINT_NAME", NULL AS TABLE_CATALOG, TC."TABLE_SCHEMA", TC."TABLE_NAME", NULL AS IS_DEFERRABLE, NULL AS INITIALLY_DEFERRED, KCU."COLUMN_NAME" FROM "INFORMATION_SCHEMA"."TABLE_CONSTRAINTS" TC JOIN "INFORMATION_SCHEMA"."KEY_COLUMN_USAGE" KCU ON TC.CONSTRAINT_NAME=KCU.CONSTRAINT_NAME AND TC.TABLE_SCHEMA=KCU.TABLE_SCHEMA AND TC.TABLE_NAME=KCU.TABLE_NAME WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA2' AND TC.TABLE_NAME='4TEST_table'
| d9f715a     | Generic  | UNNAMED on LBSCHEMA2.4test_table                   | **plan**: SELECT TC."CONSTRAINT_NAME", NULL AS TABLE_CATALOG, TC."TABLE_SCHEMA", TC."TABLE_NAME", NULL AS IS_DEFERRABLE, NULL AS INITIALLY_DEFERRED, KCU."COLUMN_NAME" FROM "INFORMATION_SCHEMA"."TABLE_CONSTRAINTS" TC JOIN "INFORMATION_SCHEMA"."KEY_COLUMN_USAGE" KCU ON TC.CONSTRAINT_NAME=KCU.CONSTRAINT_NAME AND TC.TABLE_SCHEMA=KCU.TABLE_SCHEMA AND TC.TABLE_NAME=KCU.TABLE_NAME WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA2' AND TC.TABLE_NAME='4test_table'
| 84f9fa2     | Generic  | UNNAMED on LBSCHEMA2.ANOTHERUPPERTABLE             | **plan**: SELECT TC."CONSTRAINT_NAME", NULL AS TABLE_CATALOG, TC."TABLE_SCHEMA", TC."TABLE_NAME", NULL AS IS_DEFERRABLE, NULL AS INITIALLY_DEFERRED, KCU."COLUMN_NAME" FROM "INFORMATION_SCHEMA"."TABLE_CONSTRAINTS" TC JOIN "INFORMATION_SCHEMA"."KEY_COLUMN_USAGE" KCU ON TC.CONSTRAINT_NAME=KCU.CONSTRAINT_NAME AND TC.TABLE_SCHEMA=KCU.TABLE_SCHEMA AND TC.TABLE_NAME=KCU.TABLE_NAME WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA2' AND TC.TABLE_NAME='ANOTHERUPPERTABLE'
| 76490a4     | Generic  | UNNAMED on LBSCHEMA2.AnotherMixedTable             | **plan**: SELECT TC."CONSTRAINT_NAME", NULL AS TABLE_CATALOG, TC."TABLE_SCHEMA", TC."TABLE_NAME", NULL AS IS_DEFERRABLE, NULL AS INITIALLY_DEFERRED, KCU."COLUMN_NAME" FROM "INFORMATION_SCHEMA"."TABLE_CONSTRAINTS" TC JOIN "INFORMATION_SCHEMA"."KEY_COLUMN_USAGE" KCU ON TC.CONSTRAINT_NAME=KCU.CONSTRAINT_NAME AND TC.TABLE_SCHEMA=KCU.TABLE_SCHEMA AND TC.TABLE_NAME=KCU.TABLE_NAME WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA2' AND TC.TABLE_NAME='AnotherMixedTable'
| 28f5e91     | Generic  | UNNAMED on LBSCHEMA2.CRAZY!@#\$%^&*()_+{}[]'"TABLE | **plan**: SELECT TC."CONSTRAINT_NAME", NULL AS TABLE_CATALOG, TC."TABLE_SCHEMA", TC."TABLE_NAME", NULL AS IS_DEFERRABLE, NULL AS INITIALLY_DEFERRED, KCU."COLUMN_NAME" FROM "INFORMATION_SCHEMA"."TABLE_CONSTRAINTS" TC JOIN "INFORMATION_SCHEMA"."KEY_COLUMN_USAGE" KCU ON TC.CONSTRAINT_NAME=KCU.CONSTRAINT_NAME AND TC.TABLE_SCHEMA=KCU.TABLE_SCHEMA AND TC.TABLE_NAME=KCU.TABLE_NAME WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA2' AND TC.TABLE_NAME='CRAZY!@#\$%^&*()_+{}[]''"TABLE'
| fd86db2     | Generic  | UNNAMED on LBSCHEMA2.MixedTable                    | **plan**: SELECT TC."CONSTRAINT_NAME", NULL AS TABLE_CATALOG, TC."TABLE_SCHEMA", TC."TABLE_NAME", NULL AS IS_DEFERRABLE, NULL AS INITIALLY_DEFERRED, KCU."COLUMN_NAME" FROM "INFORMATION_SCHEMA"."TABLE_CONSTRAINTS" TC JOIN "INFORMATION_SCHEMA"."KEY_COLUMN_USAGE" KCU ON TC.CONSTRAINT_NAME=KCU.CONSTRAINT_NAME AND TC.TABLE_SCHEMA=KCU.TABLE_SCHEMA AND TC.TABLE_NAME=KCU.TABLE_NAME WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA2' AND TC.TABLE_NAME='MixedTable'
| 0a9c82c     | Generic  | UNNAMED on LBSCHEMA2.ONLY_IN_LBSCHEMA2             | **plan**: SELECT TC."CONSTRAINT_NAME", NULL AS TABLE_CATALOG, TC."TABLE_SCHEMA", TC."TABLE_NAME", NULL AS IS_DEFERRABLE, NULL AS INITIALLY_DEFERRED, KCU."COLUMN_NAME" FROM "INFORMATION_SCHEMA"."TABLE_CONSTRAINTS" TC JOIN "INFORMATION_SCHEMA"."KEY_COLUMN_USAGE" KCU ON TC.CONSTRAINT_NAME=KCU.CONSTRAINT_NAME AND TC.TABLE_SCHEMA=KCU.TABLE_SCHEMA AND TC.TABLE_NAME=KCU.TABLE_NAME WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA2' AND TC.TABLE_NAME='ONLY_IN_LBSCHEMA2'
| 27851cc     | Generic  | UNNAMED on LBSCHEMA2.UPPERTABLE                    | **plan**: SELECT TC."CONSTRAINT_NAME", NULL AS TABLE_CATALOG, TC."TABLE_SCHEMA", TC."TABLE_NAME", NULL AS IS_DEFERRABLE, NULL AS INITIALLY_DEFERRED, KCU."COLUMN_NAME" FROM "INFORMATION_SCHEMA"."TABLE_CONSTRAINTS" TC JOIN "INFORMATION_SCHEMA"."KEY_COLUMN_USAGE" KCU ON TC.CONSTRAINT_NAME=KCU.CONSTRAINT_NAME AND TC.TABLE_SCHEMA=KCU.TABLE_SCHEMA AND TC.TABLE_NAME=KCU.TABLE_NAME WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA2' AND TC.TABLE_NAME='UPPERTABLE'
| 0f1ef6c     | Generic  | UNNAMED on LBSCHEMA2.anotherlowertable             | **plan**: SELECT TC."CONSTRAINT_NAME", NULL AS TABLE_CATALOG, TC."TABLE_SCHEMA", TC."TABLE_NAME", NULL AS IS_DEFERRABLE, NULL AS INITIALLY_DEFERRED, KCU."COLUMN_NAME" FROM "INFORMATION_SCHEMA"."TABLE_CONSTRAINTS" TC JOIN "INFORMATION_SCHEMA"."KEY_COLUMN_USAGE" KCU ON TC.CONSTRAINT_NAME=KCU.CONSTRAINT_NAME AND TC.TABLE_SCHEMA=KCU.TABLE_SCHEMA AND TC.TABLE_NAME=KCU.TABLE_NAME WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA2' AND TC.TABLE_NAME='anotherlowertable'
| 806937d     | Generic  | UNNAMED on LBSCHEMA2.crazy!@#\$%^&*()_+{}[]'"table | **plan**: SELECT TC."CONSTRAINT_NAME", NULL AS TABLE_CATALOG, TC."TABLE_SCHEMA", TC."TABLE_NAME", NULL AS IS_DEFERRABLE, NULL AS INITIALLY_DEFERRED, KCU."COLUMN_NAME" FROM "INFORMATION_SCHEMA"."TABLE_CONSTRAINTS" TC JOIN "INFORMATION_SCHEMA"."KEY_COLUMN_USAGE" KCU ON TC.CONSTRAINT_NAME=KCU.CONSTRAINT_NAME AND TC.TABLE_SCHEMA=KCU.TABLE_SCHEMA AND TC.TABLE_NAME=KCU.TABLE_NAME WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA2' AND TC.TABLE_NAME='crazy!@#\$%^&*()_+{}[]''"table'
| 31acef7     | Generic  | UNNAMED on LBSCHEMA2.lowertable                    | **plan**: SELECT TC."CONSTRAINT_NAME", NULL AS TABLE_CATALOG, TC."TABLE_SCHEMA", TC."TABLE_NAME", NULL AS IS_DEFERRABLE, NULL AS INITIALLY_DEFERRED, KCU."COLUMN_NAME" FROM "INFORMATION_SCHEMA"."TABLE_CONSTRAINTS" TC JOIN "INFORMATION_SCHEMA"."KEY_COLUMN_USAGE" KCU ON TC.CONSTRAINT_NAME=KCU.CONSTRAINT_NAME AND TC.TABLE_SCHEMA=KCU.TABLE_SCHEMA AND TC.TABLE_NAME=KCU.TABLE_NAME WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA2' AND TC.TABLE_NAME='lowertable'

# Test: "can find complex uq names with a table" #

- **connection:** generic standard

| Permutation | Verified | uq                                                      | OPERATIONS
| :---------- | :------- | :------------------------------------------------------ | :------
| a1c3b0d     | Generic  | 4TEST_uniqueconstraint on KNOWN_TABLE                   | **plan**: SELECT TC."CONSTRAINT_NAME", NULL AS TABLE_CATALOG, TC."TABLE_SCHEMA", TC."TABLE_NAME", NULL AS IS_DEFERRABLE, NULL AS INITIALLY_DEFERRED, KCU."COLUMN_NAME" FROM "INFORMATION_SCHEMA"."TABLE_CONSTRAINTS" TC JOIN "INFORMATION_SCHEMA"."KEY_COLUMN_USAGE" KCU ON TC.CONSTRAINT_NAME=KCU.CONSTRAINT_NAME AND TC.TABLE_SCHEMA=KCU.TABLE_SCHEMA AND TC.TABLE_NAME=KCU.TABLE_NAME WHERE TC.TABLE_NAME='KNOWN_TABLE' AND TC.CONSTRAINT_NAME='4TEST_uniqueconstraint'
| 170e977     | Generic  | 4test_uniqueconstraint on KNOWN_TABLE                   | **plan**: SELECT TC."CONSTRAINT_NAME", NULL AS TABLE_CATALOG, TC."TABLE_SCHEMA", TC."TABLE_NAME", NULL AS IS_DEFERRABLE, NULL AS INITIALLY_DEFERRED, KCU."COLUMN_NAME" FROM "INFORMATION_SCHEMA"."TABLE_CONSTRAINTS" TC JOIN "INFORMATION_SCHEMA"."KEY_COLUMN_USAGE" KCU ON TC.CONSTRAINT_NAME=KCU.CONSTRAINT_NAME AND TC.TABLE_SCHEMA=KCU.TABLE_SCHEMA AND TC.TABLE_NAME=KCU.TABLE_NAME WHERE TC.TABLE_NAME='KNOWN_TABLE' AND TC.CONSTRAINT_NAME='4test_uniqueconstraint'
| d66e48d     | Generic  | ANOTHERUPPERUNIQUECONSTRAINT on KNOWN_TABLE             | **plan**: SELECT TC."CONSTRAINT_NAME", NULL AS TABLE_CATALOG, TC."TABLE_SCHEMA", TC."TABLE_NAME", NULL AS IS_DEFERRABLE, NULL AS INITIALLY_DEFERRED, KCU."COLUMN_NAME" FROM "INFORMATION_SCHEMA"."TABLE_CONSTRAINTS" TC JOIN "INFORMATION_SCHEMA"."KEY_COLUMN_USAGE" KCU ON TC.CONSTRAINT_NAME=KCU.CONSTRAINT_NAME AND TC.TABLE_SCHEMA=KCU.TABLE_SCHEMA AND TC.TABLE_NAME=KCU.TABLE_NAME WHERE TC.TABLE_NAME='KNOWN_TABLE' AND TC.CONSTRAINT_NAME='ANOTHERUPPERUNIQUECONSTRAINT'
| fcfabb0     | Generic  | AnotherMixedUniqueConstraint on KNOWN_TABLE             | **plan**: SELECT TC."CONSTRAINT_NAME", NULL AS TABLE_CATALOG, TC."TABLE_SCHEMA", TC."TABLE_NAME", NULL AS IS_DEFERRABLE, NULL AS INITIALLY_DEFERRED, KCU."COLUMN_NAME" FROM "INFORMATION_SCHEMA"."TABLE_CONSTRAINTS" TC JOIN "INFORMATION_SCHEMA"."KEY_COLUMN_USAGE" KCU ON TC.CONSTRAINT_NAME=KCU.CONSTRAINT_NAME AND TC.TABLE_SCHEMA=KCU.TABLE_SCHEMA AND TC.TABLE_NAME=KCU.TABLE_NAME WHERE TC.TABLE_NAME='KNOWN_TABLE' AND TC.CONSTRAINT_NAME='AnotherMixedUniqueConstraint'
| 86c27b2     | Generic  | CRAZY!@#\$%^&*()_+{}[]'"UNIQUECONSTRAINT on KNOWN_TABLE | **plan**: SELECT TC."CONSTRAINT_NAME", NULL AS TABLE_CATALOG, TC."TABLE_SCHEMA", TC."TABLE_NAME", NULL AS IS_DEFERRABLE, NULL AS INITIALLY_DEFERRED, KCU."COLUMN_NAME" FROM "INFORMATION_SCHEMA"."TABLE_CONSTRAINTS" TC JOIN "INFORMATION_SCHEMA"."KEY_COLUMN_USAGE" KCU ON TC.CONSTRAINT_NAME=KCU.CONSTRAINT_NAME AND TC.TABLE_SCHEMA=KCU.TABLE_SCHEMA AND TC.TABLE_NAME=KCU.TABLE_NAME WHERE TC.TABLE_NAME='KNOWN_TABLE' AND TC.CONSTRAINT_NAME='CRAZY!@#\$%^&*()_+{}[]''"UNIQUECONSTRAINT'
| 11d069e     | Generic  | MixedUniqueConstraint on KNOWN_TABLE                    | **plan**: SELECT TC."CONSTRAINT_NAME", NULL AS TABLE_CATALOG, TC."TABLE_SCHEMA", TC."TABLE_NAME", NULL AS IS_DEFERRABLE, NULL AS INITIALLY_DEFERRED, KCU."COLUMN_NAME" FROM "INFORMATION_SCHEMA"."TABLE_CONSTRAINTS" TC JOIN "INFORMATION_SCHEMA"."KEY_COLUMN_USAGE" KCU ON TC.CONSTRAINT_NAME=KCU.CONSTRAINT_NAME AND TC.TABLE_SCHEMA=KCU.TABLE_SCHEMA AND TC.TABLE_NAME=KCU.TABLE_NAME WHERE TC.TABLE_NAME='KNOWN_TABLE' AND TC.CONSTRAINT_NAME='MixedUniqueConstraint'
| 0c72c6d     | Generic  | UPPERUNIQUECONSTRAINT on KNOWN_TABLE                    | **plan**: SELECT TC."CONSTRAINT_NAME", NULL AS TABLE_CATALOG, TC."TABLE_SCHEMA", TC."TABLE_NAME", NULL AS IS_DEFERRABLE, NULL AS INITIALLY_DEFERRED, KCU."COLUMN_NAME" FROM "INFORMATION_SCHEMA"."TABLE_CONSTRAINTS" TC JOIN "INFORMATION_SCHEMA"."KEY_COLUMN_USAGE" KCU ON TC.CONSTRAINT_NAME=KCU.CONSTRAINT_NAME AND TC.TABLE_SCHEMA=KCU.TABLE_SCHEMA AND TC.TABLE_NAME=KCU.TABLE_NAME WHERE TC.TABLE_NAME='KNOWN_TABLE' AND TC.CONSTRAINT_NAME='UPPERUNIQUECONSTRAINT'
| 4bc99fb     | Generic  | anotherloweruniqueconstraint on KNOWN_TABLE             | **plan**: SELECT TC."CONSTRAINT_NAME", NULL AS TABLE_CATALOG, TC."TABLE_SCHEMA", TC."TABLE_NAME", NULL AS IS_DEFERRABLE, NULL AS INITIALLY_DEFERRED, KCU."COLUMN_NAME" FROM "INFORMATION_SCHEMA"."TABLE_CONSTRAINTS" TC JOIN "INFORMATION_SCHEMA"."KEY_COLUMN_USAGE" KCU ON TC.CONSTRAINT_NAME=KCU.CONSTRAINT_NAME AND TC.TABLE_SCHEMA=KCU.TABLE_SCHEMA AND TC.TABLE_NAME=KCU.TABLE_NAME WHERE TC.TABLE_NAME='KNOWN_TABLE' AND TC.CONSTRAINT_NAME='anotherloweruniqueconstraint'
| 491ebd6     | Generic  | crazy!@#\$%^&*()_+{}[]'"uniqueconstraint on KNOWN_TABLE | **plan**: SELECT TC."CONSTRAINT_NAME", NULL AS TABLE_CATALOG, TC."TABLE_SCHEMA", TC."TABLE_NAME", NULL AS IS_DEFERRABLE, NULL AS INITIALLY_DEFERRED, KCU."COLUMN_NAME" FROM "INFORMATION_SCHEMA"."TABLE_CONSTRAINTS" TC JOIN "INFORMATION_SCHEMA"."KEY_COLUMN_USAGE" KCU ON TC.CONSTRAINT_NAME=KCU.CONSTRAINT_NAME AND TC.TABLE_SCHEMA=KCU.TABLE_SCHEMA AND TC.TABLE_NAME=KCU.TABLE_NAME WHERE TC.TABLE_NAME='KNOWN_TABLE' AND TC.CONSTRAINT_NAME='crazy!@#\$%^&*()_+{}[]''"uniqueconstraint'
| c5b17c3     | Generic  | loweruniqueconstraint on KNOWN_TABLE                    | **plan**: SELECT TC."CONSTRAINT_NAME", NULL AS TABLE_CATALOG, TC."TABLE_SCHEMA", TC."TABLE_NAME", NULL AS IS_DEFERRABLE, NULL AS INITIALLY_DEFERRED, KCU."COLUMN_NAME" FROM "INFORMATION_SCHEMA"."TABLE_CONSTRAINTS" TC JOIN "INFORMATION_SCHEMA"."KEY_COLUMN_USAGE" KCU ON TC.CONSTRAINT_NAME=KCU.CONSTRAINT_NAME AND TC.TABLE_SCHEMA=KCU.TABLE_SCHEMA AND TC.TABLE_NAME=KCU.TABLE_NAME WHERE TC.TABLE_NAME='KNOWN_TABLE' AND TC.CONSTRAINT_NAME='loweruniqueconstraint'

# Test: "can find complex uq names without a table" #

- **connection:** generic standard

| Permutation | Verified | uq                                                  | OPERATIONS
| :---------- | :------- | :-------------------------------------------------- | :------
| 991c7d4     | Generic  | 4TEST_uniqueconstraint on UNNAMED                   | **plan**: SELECT TC."CONSTRAINT_NAME", NULL AS TABLE_CATALOG, TC."TABLE_SCHEMA", TC."TABLE_NAME", NULL AS IS_DEFERRABLE, NULL AS INITIALLY_DEFERRED, KCU."COLUMN_NAME" FROM "INFORMATION_SCHEMA"."TABLE_CONSTRAINTS" TC JOIN "INFORMATION_SCHEMA"."KEY_COLUMN_USAGE" KCU ON TC.CONSTRAINT_NAME=KCU.CONSTRAINT_NAME AND TC.TABLE_SCHEMA=KCU.TABLE_SCHEMA AND TC.TABLE_NAME=KCU.TABLE_NAME WHERE TC.CONSTRAINT_NAME='4TEST_uniqueconstraint'
| b1f2989     | Generic  | 4test_uniqueconstraint on UNNAMED                   | **plan**: SELECT TC."CONSTRAINT_NAME", NULL AS TABLE_CATALOG, TC."TABLE_SCHEMA", TC."TABLE_NAME", NULL AS IS_DEFERRABLE, NULL AS INITIALLY_DEFERRED, KCU."COLUMN_NAME" FROM "INFORMATION_SCHEMA"."TABLE_CONSTRAINTS" TC JOIN "INFORMATION_SCHEMA"."KEY_COLUMN_USAGE" KCU ON TC.CONSTRAINT_NAME=KCU.CONSTRAINT_NAME AND TC.TABLE_SCHEMA=KCU.TABLE_SCHEMA AND TC.TABLE_NAME=KCU.TABLE_NAME WHERE TC.CONSTRAINT_NAME='4test_uniqueconstraint'
| 815c01d     | Generic  | ANOTHERUPPERUNIQUECONSTRAINT on UNNAMED             | **plan**: SELECT TC."CONSTRAINT_NAME", NULL AS TABLE_CATALOG, TC."TABLE_SCHEMA", TC."TABLE_NAME", NULL AS IS_DEFERRABLE, NULL AS INITIALLY_DEFERRED, KCU."COLUMN_NAME" FROM "INFORMATION_SCHEMA"."TABLE_CONSTRAINTS" TC JOIN "INFORMATION_SCHEMA"."KEY_COLUMN_USAGE" KCU ON TC.CONSTRAINT_NAME=KCU.CONSTRAINT_NAME AND TC.TABLE_SCHEMA=KCU.TABLE_SCHEMA AND TC.TABLE_NAME=KCU.TABLE_NAME WHERE TC.CONSTRAINT_NAME='ANOTHERUPPERUNIQUECONSTRAINT'
| beaafeb     | Generic  | AnotherMixedUniqueConstraint on UNNAMED             | **plan**: SELECT TC."CONSTRAINT_NAME", NULL AS TABLE_CATALOG, TC."TABLE_SCHEMA", TC."TABLE_NAME", NULL AS IS_DEFERRABLE, NULL AS INITIALLY_DEFERRED, KCU."COLUMN_NAME" FROM "INFORMATION_SCHEMA"."TABLE_CONSTRAINTS" TC JOIN "INFORMATION_SCHEMA"."KEY_COLUMN_USAGE" KCU ON TC.CONSTRAINT_NAME=KCU.CONSTRAINT_NAME AND TC.TABLE_SCHEMA=KCU.TABLE_SCHEMA AND TC.TABLE_NAME=KCU.TABLE_NAME WHERE TC.CONSTRAINT_NAME='AnotherMixedUniqueConstraint'
| 85bb0eb     | Generic  | CRAZY!@#\$%^&*()_+{}[]'"UNIQUECONSTRAINT on UNNAMED | **plan**: SELECT TC."CONSTRAINT_NAME", NULL AS TABLE_CATALOG, TC."TABLE_SCHEMA", TC."TABLE_NAME", NULL AS IS_DEFERRABLE, NULL AS INITIALLY_DEFERRED, KCU."COLUMN_NAME" FROM "INFORMATION_SCHEMA"."TABLE_CONSTRAINTS" TC JOIN "INFORMATION_SCHEMA"."KEY_COLUMN_USAGE" KCU ON TC.CONSTRAINT_NAME=KCU.CONSTRAINT_NAME AND TC.TABLE_SCHEMA=KCU.TABLE_SCHEMA AND TC.TABLE_NAME=KCU.TABLE_NAME WHERE TC.CONSTRAINT_NAME='CRAZY!@#\$%^&*()_+{}[]''"UNIQUECONSTRAINT'
| 13fe513     | Generic  | MixedUniqueConstraint on UNNAMED                    | **plan**: SELECT TC."CONSTRAINT_NAME", NULL AS TABLE_CATALOG, TC."TABLE_SCHEMA", TC."TABLE_NAME", NULL AS IS_DEFERRABLE, NULL AS INITIALLY_DEFERRED, KCU."COLUMN_NAME" FROM "INFORMATION_SCHEMA"."TABLE_CONSTRAINTS" TC JOIN "INFORMATION_SCHEMA"."KEY_COLUMN_USAGE" KCU ON TC.CONSTRAINT_NAME=KCU.CONSTRAINT_NAME AND TC.TABLE_SCHEMA=KCU.TABLE_SCHEMA AND TC.TABLE_NAME=KCU.TABLE_NAME WHERE TC.CONSTRAINT_NAME='MixedUniqueConstraint'
| a3bdb41     | Generic  | UPPERUNIQUECONSTRAINT on UNNAMED                    | **plan**: SELECT TC."CONSTRAINT_NAME", NULL AS TABLE_CATALOG, TC."TABLE_SCHEMA", TC."TABLE_NAME", NULL AS IS_DEFERRABLE, NULL AS INITIALLY_DEFERRED, KCU."COLUMN_NAME" FROM "INFORMATION_SCHEMA"."TABLE_CONSTRAINTS" TC JOIN "INFORMATION_SCHEMA"."KEY_COLUMN_USAGE" KCU ON TC.CONSTRAINT_NAME=KCU.CONSTRAINT_NAME AND TC.TABLE_SCHEMA=KCU.TABLE_SCHEMA AND TC.TABLE_NAME=KCU.TABLE_NAME WHERE TC.CONSTRAINT_NAME='UPPERUNIQUECONSTRAINT'
| 89558b8     | Generic  | anotherloweruniqueconstraint on UNNAMED             | **plan**: SELECT TC."CONSTRAINT_NAME", NULL AS TABLE_CATALOG, TC."TABLE_SCHEMA", TC."TABLE_NAME", NULL AS IS_DEFERRABLE, NULL AS INITIALLY_DEFERRED, KCU."COLUMN_NAME" FROM "INFORMATION_SCHEMA"."TABLE_CONSTRAINTS" TC JOIN "INFORMATION_SCHEMA"."KEY_COLUMN_USAGE" KCU ON TC.CONSTRAINT_NAME=KCU.CONSTRAINT_NAME AND TC.TABLE_SCHEMA=KCU.TABLE_SCHEMA AND TC.TABLE_NAME=KCU.TABLE_NAME WHERE TC.CONSTRAINT_NAME='anotherloweruniqueconstraint'
| e280514     | Generic  | crazy!@#\$%^&*()_+{}[]'"uniqueconstraint on UNNAMED | **plan**: SELECT TC."CONSTRAINT_NAME", NULL AS TABLE_CATALOG, TC."TABLE_SCHEMA", TC."TABLE_NAME", NULL AS IS_DEFERRABLE, NULL AS INITIALLY_DEFERRED, KCU."COLUMN_NAME" FROM "INFORMATION_SCHEMA"."TABLE_CONSTRAINTS" TC JOIN "INFORMATION_SCHEMA"."KEY_COLUMN_USAGE" KCU ON TC.CONSTRAINT_NAME=KCU.CONSTRAINT_NAME AND TC.TABLE_SCHEMA=KCU.TABLE_SCHEMA AND TC.TABLE_NAME=KCU.TABLE_NAME WHERE TC.CONSTRAINT_NAME='crazy!@#\$%^&*()_+{}[]''"uniqueconstraint'
| aceb020     | Generic  | loweruniqueconstraint on UNNAMED                    | **plan**: SELECT TC."CONSTRAINT_NAME", NULL AS TABLE_CATALOG, TC."TABLE_SCHEMA", TC."TABLE_NAME", NULL AS IS_DEFERRABLE, NULL AS INITIALLY_DEFERRED, KCU."COLUMN_NAME" FROM "INFORMATION_SCHEMA"."TABLE_CONSTRAINTS" TC JOIN "INFORMATION_SCHEMA"."KEY_COLUMN_USAGE" KCU ON TC.CONSTRAINT_NAME=KCU.CONSTRAINT_NAME AND TC.TABLE_SCHEMA=KCU.TABLE_SCHEMA AND TC.TABLE_NAME=KCU.TABLE_NAME WHERE TC.CONSTRAINT_NAME='loweruniqueconstraint'

# Test Version: "5fc9e0" #