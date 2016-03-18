**NOTE: This output is generated and parsed by TestMD. Please read it, but DO NOT EDIT MANUALLY**

# Test: "Finds multi-column UQs correctly" #

- **connection:** h2 standard

| Permutation | Verified | schema    | OPERATIONS
| :---------- | :------- | :-------- | :------
| 8caa091     | true     | LBSCHEMA2 | **plan**: SELECT TC."CONSTRAINT_NAME", TC."TABLE_CATALOG", TC."TABLE_SCHEMA", TC."TABLE_NAME", FALSE AS IS_DEFERRABLE, FALSE AS INITIALLY_DEFERRED, "COLUMN_LIST" FROM "INFORMATION_SCHEMA"."CONSTRAINTS" TC WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA2' AND TC.TABLE_NAME='TABLE_NAME' AND TC.CONSTRAINT_NAME='UQ_TEST'
| 63bb730     | true     | PUBLIC    | **plan**: SELECT TC."CONSTRAINT_NAME", TC."TABLE_CATALOG", TC."TABLE_SCHEMA", TC."TABLE_NAME", FALSE AS IS_DEFERRABLE, FALSE AS INITIALLY_DEFERRED, "COLUMN_LIST" FROM "INFORMATION_SCHEMA"."CONSTRAINTS" TC WHERE TC.CONSTRAINT_SCHEMA='PUBLIC' AND TC.TABLE_NAME='TABLE_NAME' AND TC.CONSTRAINT_NAME='UQ_TEST'

# Test: "can find all uniqueConstraints in a fully qualified complex table name" #

- **connection:** h2 standard

| Permutation | Verified | table                                   | OPERATIONS
| :---------- | :------- | :-------------------------------------- | :------
| 0016761     | true     | LBSCHEMA2.4TEST_table                   | **plan**: SELECT TC."CONSTRAINT_NAME", TC."TABLE_CATALOG", TC."TABLE_SCHEMA", TC."TABLE_NAME", FALSE AS IS_DEFERRABLE, FALSE AS INITIALLY_DEFERRED, "COLUMN_LIST" FROM "INFORMATION_SCHEMA"."CONSTRAINTS" TC WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA2' AND TC.TABLE_NAME='4TEST_table'
| fe56897     | true     | LBSCHEMA2.4test_table                   | **plan**: SELECT TC."CONSTRAINT_NAME", TC."TABLE_CATALOG", TC."TABLE_SCHEMA", TC."TABLE_NAME", FALSE AS IS_DEFERRABLE, FALSE AS INITIALLY_DEFERRED, "COLUMN_LIST" FROM "INFORMATION_SCHEMA"."CONSTRAINTS" TC WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA2' AND TC.TABLE_NAME='4test_table'
| 791ecdc     | true     | LBSCHEMA2.ANOTHERUPPERTABLE             | **plan**: SELECT TC."CONSTRAINT_NAME", TC."TABLE_CATALOG", TC."TABLE_SCHEMA", TC."TABLE_NAME", FALSE AS IS_DEFERRABLE, FALSE AS INITIALLY_DEFERRED, "COLUMN_LIST" FROM "INFORMATION_SCHEMA"."CONSTRAINTS" TC WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA2' AND TC.TABLE_NAME='ANOTHERUPPERTABLE'
| 945d60b     | true     | LBSCHEMA2.AnotherMixedTable             | **plan**: SELECT TC."CONSTRAINT_NAME", TC."TABLE_CATALOG", TC."TABLE_SCHEMA", TC."TABLE_NAME", FALSE AS IS_DEFERRABLE, FALSE AS INITIALLY_DEFERRED, "COLUMN_LIST" FROM "INFORMATION_SCHEMA"."CONSTRAINTS" TC WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA2' AND TC.TABLE_NAME='AnotherMixedTable'
| 644d6ec     | true     | LBSCHEMA2.CRAZY!@#\$%^&*()_+{}[]'"TABLE | **plan**: SELECT TC."CONSTRAINT_NAME", TC."TABLE_CATALOG", TC."TABLE_SCHEMA", TC."TABLE_NAME", FALSE AS IS_DEFERRABLE, FALSE AS INITIALLY_DEFERRED, "COLUMN_LIST" FROM "INFORMATION_SCHEMA"."CONSTRAINTS" TC WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA2' AND TC.TABLE_NAME='CRAZY!@#\$%^&*()_+{}[]''"TABLE'
| e731b70     | true     | LBSCHEMA2.MixedTable                    | **plan**: SELECT TC."CONSTRAINT_NAME", TC."TABLE_CATALOG", TC."TABLE_SCHEMA", TC."TABLE_NAME", FALSE AS IS_DEFERRABLE, FALSE AS INITIALLY_DEFERRED, "COLUMN_LIST" FROM "INFORMATION_SCHEMA"."CONSTRAINTS" TC WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA2' AND TC.TABLE_NAME='MixedTable'
| e10b18d     | true     | LBSCHEMA2.ONLY_IN_LBSCHEMA2             | **plan**: SELECT TC."CONSTRAINT_NAME", TC."TABLE_CATALOG", TC."TABLE_SCHEMA", TC."TABLE_NAME", FALSE AS IS_DEFERRABLE, FALSE AS INITIALLY_DEFERRED, "COLUMN_LIST" FROM "INFORMATION_SCHEMA"."CONSTRAINTS" TC WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA2' AND TC.TABLE_NAME='ONLY_IN_LBSCHEMA2'
| 9dfc94b     | true     | LBSCHEMA2.UPPERTABLE                    | **plan**: SELECT TC."CONSTRAINT_NAME", TC."TABLE_CATALOG", TC."TABLE_SCHEMA", TC."TABLE_NAME", FALSE AS IS_DEFERRABLE, FALSE AS INITIALLY_DEFERRED, "COLUMN_LIST" FROM "INFORMATION_SCHEMA"."CONSTRAINTS" TC WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA2' AND TC.TABLE_NAME='UPPERTABLE'
| 416359f     | true     | LBSCHEMA2.anotherlowertable             | **plan**: SELECT TC."CONSTRAINT_NAME", TC."TABLE_CATALOG", TC."TABLE_SCHEMA", TC."TABLE_NAME", FALSE AS IS_DEFERRABLE, FALSE AS INITIALLY_DEFERRED, "COLUMN_LIST" FROM "INFORMATION_SCHEMA"."CONSTRAINTS" TC WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA2' AND TC.TABLE_NAME='anotherlowertable'
| 28ea09f     | true     | LBSCHEMA2.crazy!@#\$%^&*()_+{}[]'"table | **plan**: SELECT TC."CONSTRAINT_NAME", TC."TABLE_CATALOG", TC."TABLE_SCHEMA", TC."TABLE_NAME", FALSE AS IS_DEFERRABLE, FALSE AS INITIALLY_DEFERRED, "COLUMN_LIST" FROM "INFORMATION_SCHEMA"."CONSTRAINTS" TC WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA2' AND TC.TABLE_NAME='crazy!@#\$%^&*()_+{}[]''"table'
| 993cd64     | true     | LBSCHEMA2.lowertable                    | **plan**: SELECT TC."CONSTRAINT_NAME", TC."TABLE_CATALOG", TC."TABLE_SCHEMA", TC."TABLE_NAME", FALSE AS IS_DEFERRABLE, FALSE AS INITIALLY_DEFERRED, "COLUMN_LIST" FROM "INFORMATION_SCHEMA"."CONSTRAINTS" TC WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA2' AND TC.TABLE_NAME='lowertable'
| 9581d79     | true     | PUBLIC.4TEST_table                      | **plan**: SELECT TC."CONSTRAINT_NAME", TC."TABLE_CATALOG", TC."TABLE_SCHEMA", TC."TABLE_NAME", FALSE AS IS_DEFERRABLE, FALSE AS INITIALLY_DEFERRED, "COLUMN_LIST" FROM "INFORMATION_SCHEMA"."CONSTRAINTS" TC WHERE TC.CONSTRAINT_SCHEMA='PUBLIC' AND TC.TABLE_NAME='4TEST_table'
| e344883     | true     | PUBLIC.4test_table                      | **plan**: SELECT TC."CONSTRAINT_NAME", TC."TABLE_CATALOG", TC."TABLE_SCHEMA", TC."TABLE_NAME", FALSE AS IS_DEFERRABLE, FALSE AS INITIALLY_DEFERRED, "COLUMN_LIST" FROM "INFORMATION_SCHEMA"."CONSTRAINTS" TC WHERE TC.CONSTRAINT_SCHEMA='PUBLIC' AND TC.TABLE_NAME='4test_table'
| b087168     | true     | PUBLIC.ANOTHERUPPERTABLE                | **plan**: SELECT TC."CONSTRAINT_NAME", TC."TABLE_CATALOG", TC."TABLE_SCHEMA", TC."TABLE_NAME", FALSE AS IS_DEFERRABLE, FALSE AS INITIALLY_DEFERRED, "COLUMN_LIST" FROM "INFORMATION_SCHEMA"."CONSTRAINTS" TC WHERE TC.CONSTRAINT_SCHEMA='PUBLIC' AND TC.TABLE_NAME='ANOTHERUPPERTABLE'
| 1d572dc     | true     | PUBLIC.AnotherMixedTable                | **plan**: SELECT TC."CONSTRAINT_NAME", TC."TABLE_CATALOG", TC."TABLE_SCHEMA", TC."TABLE_NAME", FALSE AS IS_DEFERRABLE, FALSE AS INITIALLY_DEFERRED, "COLUMN_LIST" FROM "INFORMATION_SCHEMA"."CONSTRAINTS" TC WHERE TC.CONSTRAINT_SCHEMA='PUBLIC' AND TC.TABLE_NAME='AnotherMixedTable'
| 69cf0ea     | true     | PUBLIC.CRAZY!@#\$%^&*()_+{}[]'"TABLE    | **plan**: SELECT TC."CONSTRAINT_NAME", TC."TABLE_CATALOG", TC."TABLE_SCHEMA", TC."TABLE_NAME", FALSE AS IS_DEFERRABLE, FALSE AS INITIALLY_DEFERRED, "COLUMN_LIST" FROM "INFORMATION_SCHEMA"."CONSTRAINTS" TC WHERE TC.CONSTRAINT_SCHEMA='PUBLIC' AND TC.TABLE_NAME='CRAZY!@#\$%^&*()_+{}[]''"TABLE'
| ec2093e     | true     | PUBLIC.MixedTable                       | **plan**: SELECT TC."CONSTRAINT_NAME", TC."TABLE_CATALOG", TC."TABLE_SCHEMA", TC."TABLE_NAME", FALSE AS IS_DEFERRABLE, FALSE AS INITIALLY_DEFERRED, "COLUMN_LIST" FROM "INFORMATION_SCHEMA"."CONSTRAINTS" TC WHERE TC.CONSTRAINT_SCHEMA='PUBLIC' AND TC.TABLE_NAME='MixedTable'
| 6e5bf84     | true     | PUBLIC.ONLY_IN_PUBLIC                   | **plan**: SELECT TC."CONSTRAINT_NAME", TC."TABLE_CATALOG", TC."TABLE_SCHEMA", TC."TABLE_NAME", FALSE AS IS_DEFERRABLE, FALSE AS INITIALLY_DEFERRED, "COLUMN_LIST" FROM "INFORMATION_SCHEMA"."CONSTRAINTS" TC WHERE TC.CONSTRAINT_SCHEMA='PUBLIC' AND TC.TABLE_NAME='ONLY_IN_PUBLIC'
| 35a9095     | true     | PUBLIC.UPPERTABLE                       | **plan**: SELECT TC."CONSTRAINT_NAME", TC."TABLE_CATALOG", TC."TABLE_SCHEMA", TC."TABLE_NAME", FALSE AS IS_DEFERRABLE, FALSE AS INITIALLY_DEFERRED, "COLUMN_LIST" FROM "INFORMATION_SCHEMA"."CONSTRAINTS" TC WHERE TC.CONSTRAINT_SCHEMA='PUBLIC' AND TC.TABLE_NAME='UPPERTABLE'
| f79c86b     | true     | PUBLIC.anotherlowertable                | **plan**: SELECT TC."CONSTRAINT_NAME", TC."TABLE_CATALOG", TC."TABLE_SCHEMA", TC."TABLE_NAME", FALSE AS IS_DEFERRABLE, FALSE AS INITIALLY_DEFERRED, "COLUMN_LIST" FROM "INFORMATION_SCHEMA"."CONSTRAINTS" TC WHERE TC.CONSTRAINT_SCHEMA='PUBLIC' AND TC.TABLE_NAME='anotherlowertable'
| dc4e6fc     | true     | PUBLIC.crazy!@#\$%^&*()_+{}[]'"table    | **plan**: SELECT TC."CONSTRAINT_NAME", TC."TABLE_CATALOG", TC."TABLE_SCHEMA", TC."TABLE_NAME", FALSE AS IS_DEFERRABLE, FALSE AS INITIALLY_DEFERRED, "COLUMN_LIST" FROM "INFORMATION_SCHEMA"."CONSTRAINTS" TC WHERE TC.CONSTRAINT_SCHEMA='PUBLIC' AND TC.TABLE_NAME='crazy!@#\$%^&*()_+{}[]''"table'
| df2559a     | true     | PUBLIC.lowertable                       | **plan**: SELECT TC."CONSTRAINT_NAME", TC."TABLE_CATALOG", TC."TABLE_SCHEMA", TC."TABLE_NAME", FALSE AS IS_DEFERRABLE, FALSE AS INITIALLY_DEFERRED, "COLUMN_LIST" FROM "INFORMATION_SCHEMA"."CONSTRAINTS" TC WHERE TC.CONSTRAINT_SCHEMA='PUBLIC' AND TC.TABLE_NAME='lowertable'

# Test: "can find all uniqueConstraints related to a schema" #

- **connection:** h2 standard

| Permutation | Verified | schema    | OPERATIONS
| :---------- | :------- | :-------- | :------
| 8caa091     | true     | LBSCHEMA2 | **plan**: SELECT TC."CONSTRAINT_NAME", TC."TABLE_CATALOG", TC."TABLE_SCHEMA", TC."TABLE_NAME", FALSE AS IS_DEFERRABLE, FALSE AS INITIALLY_DEFERRED, "COLUMN_LIST" FROM "INFORMATION_SCHEMA"."CONSTRAINTS" TC WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA2'
| 63bb730     | true     | PUBLIC    | **plan**: SELECT TC."CONSTRAINT_NAME", TC."TABLE_CATALOG", TC."TABLE_SCHEMA", TC."TABLE_NAME", FALSE AS IS_DEFERRABLE, FALSE AS INITIALLY_DEFERRED, "COLUMN_LIST" FROM "INFORMATION_SCHEMA"."CONSTRAINTS" TC WHERE TC.CONSTRAINT_SCHEMA='PUBLIC'

# Test: "can find all uniqueConstraints related to a table with a null name" #

- **connection:** h2 standard

| Permutation | Verified | table             | OPERATIONS
| :---------- | :------- | :---------------- | :------
| d371197     | true     | LBSCHEMA2.UNNAMED | **plan**: SELECT TC."CONSTRAINT_NAME", TC."TABLE_CATALOG", TC."TABLE_SCHEMA", TC."TABLE_NAME", FALSE AS IS_DEFERRABLE, FALSE AS INITIALLY_DEFERRED, "COLUMN_LIST" FROM "INFORMATION_SCHEMA"."CONSTRAINTS" TC WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA2'
| 0eafdcd     | true     | PUBLIC.UNNAMED    | **plan**: SELECT TC."CONSTRAINT_NAME", TC."TABLE_CATALOG", TC."TABLE_SCHEMA", TC."TABLE_NAME", FALSE AS IS_DEFERRABLE, FALSE AS INITIALLY_DEFERRED, "COLUMN_LIST" FROM "INFORMATION_SCHEMA"."CONSTRAINTS" TC WHERE TC.CONSTRAINT_SCHEMA='PUBLIC'

# Test: "can find by UniqueConstraintReference with a table name but null constraint name" #

- **connection:** h2 standard

| Permutation | Verified | uq                                                 | OPERATIONS
| :---------- | :------- | :------------------------------------------------- | :------
| 78a1f6d     | true     | UNNAMED on LBSCHEMA2.4TEST_table                   | **plan**: SELECT TC."CONSTRAINT_NAME", TC."TABLE_CATALOG", TC."TABLE_SCHEMA", TC."TABLE_NAME", FALSE AS IS_DEFERRABLE, FALSE AS INITIALLY_DEFERRED, "COLUMN_LIST" FROM "INFORMATION_SCHEMA"."CONSTRAINTS" TC WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA2' AND TC.TABLE_NAME='4TEST_table'
| dc4215f     | true     | UNNAMED on LBSCHEMA2.4test_table                   | **plan**: SELECT TC."CONSTRAINT_NAME", TC."TABLE_CATALOG", TC."TABLE_SCHEMA", TC."TABLE_NAME", FALSE AS IS_DEFERRABLE, FALSE AS INITIALLY_DEFERRED, "COLUMN_LIST" FROM "INFORMATION_SCHEMA"."CONSTRAINTS" TC WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA2' AND TC.TABLE_NAME='4test_table'
| 8f4465e     | true     | UNNAMED on LBSCHEMA2.ANOTHERUPPERTABLE             | **plan**: SELECT TC."CONSTRAINT_NAME", TC."TABLE_CATALOG", TC."TABLE_SCHEMA", TC."TABLE_NAME", FALSE AS IS_DEFERRABLE, FALSE AS INITIALLY_DEFERRED, "COLUMN_LIST" FROM "INFORMATION_SCHEMA"."CONSTRAINTS" TC WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA2' AND TC.TABLE_NAME='ANOTHERUPPERTABLE'
| 1e9fc2d     | true     | UNNAMED on LBSCHEMA2.AnotherMixedTable             | **plan**: SELECT TC."CONSTRAINT_NAME", TC."TABLE_CATALOG", TC."TABLE_SCHEMA", TC."TABLE_NAME", FALSE AS IS_DEFERRABLE, FALSE AS INITIALLY_DEFERRED, "COLUMN_LIST" FROM "INFORMATION_SCHEMA"."CONSTRAINTS" TC WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA2' AND TC.TABLE_NAME='AnotherMixedTable'
| 4733d2c     | true     | UNNAMED on LBSCHEMA2.CRAZY!@#\$%^&*()_+{}[]'"TABLE | **plan**: SELECT TC."CONSTRAINT_NAME", TC."TABLE_CATALOG", TC."TABLE_SCHEMA", TC."TABLE_NAME", FALSE AS IS_DEFERRABLE, FALSE AS INITIALLY_DEFERRED, "COLUMN_LIST" FROM "INFORMATION_SCHEMA"."CONSTRAINTS" TC WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA2' AND TC.TABLE_NAME='CRAZY!@#\$%^&*()_+{}[]''"TABLE'
| d264f4f     | true     | UNNAMED on LBSCHEMA2.MixedTable                    | **plan**: SELECT TC."CONSTRAINT_NAME", TC."TABLE_CATALOG", TC."TABLE_SCHEMA", TC."TABLE_NAME", FALSE AS IS_DEFERRABLE, FALSE AS INITIALLY_DEFERRED, "COLUMN_LIST" FROM "INFORMATION_SCHEMA"."CONSTRAINTS" TC WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA2' AND TC.TABLE_NAME='MixedTable'
| 7e5085f     | true     | UNNAMED on LBSCHEMA2.ONLY_IN_LBSCHEMA2             | **plan**: SELECT TC."CONSTRAINT_NAME", TC."TABLE_CATALOG", TC."TABLE_SCHEMA", TC."TABLE_NAME", FALSE AS IS_DEFERRABLE, FALSE AS INITIALLY_DEFERRED, "COLUMN_LIST" FROM "INFORMATION_SCHEMA"."CONSTRAINTS" TC WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA2' AND TC.TABLE_NAME='ONLY_IN_LBSCHEMA2'
| 115f8d4     | true     | UNNAMED on LBSCHEMA2.UPPERTABLE                    | **plan**: SELECT TC."CONSTRAINT_NAME", TC."TABLE_CATALOG", TC."TABLE_SCHEMA", TC."TABLE_NAME", FALSE AS IS_DEFERRABLE, FALSE AS INITIALLY_DEFERRED, "COLUMN_LIST" FROM "INFORMATION_SCHEMA"."CONSTRAINTS" TC WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA2' AND TC.TABLE_NAME='UPPERTABLE'
| 663b73e     | true     | UNNAMED on LBSCHEMA2.anotherlowertable             | **plan**: SELECT TC."CONSTRAINT_NAME", TC."TABLE_CATALOG", TC."TABLE_SCHEMA", TC."TABLE_NAME", FALSE AS IS_DEFERRABLE, FALSE AS INITIALLY_DEFERRED, "COLUMN_LIST" FROM "INFORMATION_SCHEMA"."CONSTRAINTS" TC WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA2' AND TC.TABLE_NAME='anotherlowertable'
| bc7b5c9     | true     | UNNAMED on LBSCHEMA2.crazy!@#\$%^&*()_+{}[]'"table | **plan**: SELECT TC."CONSTRAINT_NAME", TC."TABLE_CATALOG", TC."TABLE_SCHEMA", TC."TABLE_NAME", FALSE AS IS_DEFERRABLE, FALSE AS INITIALLY_DEFERRED, "COLUMN_LIST" FROM "INFORMATION_SCHEMA"."CONSTRAINTS" TC WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA2' AND TC.TABLE_NAME='crazy!@#\$%^&*()_+{}[]''"table'
| 2f53124     | true     | UNNAMED on LBSCHEMA2.lowertable                    | **plan**: SELECT TC."CONSTRAINT_NAME", TC."TABLE_CATALOG", TC."TABLE_SCHEMA", TC."TABLE_NAME", FALSE AS IS_DEFERRABLE, FALSE AS INITIALLY_DEFERRED, "COLUMN_LIST" FROM "INFORMATION_SCHEMA"."CONSTRAINTS" TC WHERE TC.CONSTRAINT_SCHEMA='LBSCHEMA2' AND TC.TABLE_NAME='lowertable'
| 140d7a9     | true     | UNNAMED on PUBLIC.4TEST_table                      | **plan**: SELECT TC."CONSTRAINT_NAME", TC."TABLE_CATALOG", TC."TABLE_SCHEMA", TC."TABLE_NAME", FALSE AS IS_DEFERRABLE, FALSE AS INITIALLY_DEFERRED, "COLUMN_LIST" FROM "INFORMATION_SCHEMA"."CONSTRAINTS" TC WHERE TC.CONSTRAINT_SCHEMA='PUBLIC' AND TC.TABLE_NAME='4TEST_table'
| 7fe2ecb     | true     | UNNAMED on PUBLIC.4test_table                      | **plan**: SELECT TC."CONSTRAINT_NAME", TC."TABLE_CATALOG", TC."TABLE_SCHEMA", TC."TABLE_NAME", FALSE AS IS_DEFERRABLE, FALSE AS INITIALLY_DEFERRED, "COLUMN_LIST" FROM "INFORMATION_SCHEMA"."CONSTRAINTS" TC WHERE TC.CONSTRAINT_SCHEMA='PUBLIC' AND TC.TABLE_NAME='4test_table'
| 01644a7     | true     | UNNAMED on PUBLIC.ANOTHERUPPERTABLE                | **plan**: SELECT TC."CONSTRAINT_NAME", TC."TABLE_CATALOG", TC."TABLE_SCHEMA", TC."TABLE_NAME", FALSE AS IS_DEFERRABLE, FALSE AS INITIALLY_DEFERRED, "COLUMN_LIST" FROM "INFORMATION_SCHEMA"."CONSTRAINTS" TC WHERE TC.CONSTRAINT_SCHEMA='PUBLIC' AND TC.TABLE_NAME='ANOTHERUPPERTABLE'
| e0cfecb     | true     | UNNAMED on PUBLIC.AnotherMixedTable                | **plan**: SELECT TC."CONSTRAINT_NAME", TC."TABLE_CATALOG", TC."TABLE_SCHEMA", TC."TABLE_NAME", FALSE AS IS_DEFERRABLE, FALSE AS INITIALLY_DEFERRED, "COLUMN_LIST" FROM "INFORMATION_SCHEMA"."CONSTRAINTS" TC WHERE TC.CONSTRAINT_SCHEMA='PUBLIC' AND TC.TABLE_NAME='AnotherMixedTable'
| 5e114e5     | true     | UNNAMED on PUBLIC.CRAZY!@#\$%^&*()_+{}[]'"TABLE    | **plan**: SELECT TC."CONSTRAINT_NAME", TC."TABLE_CATALOG", TC."TABLE_SCHEMA", TC."TABLE_NAME", FALSE AS IS_DEFERRABLE, FALSE AS INITIALLY_DEFERRED, "COLUMN_LIST" FROM "INFORMATION_SCHEMA"."CONSTRAINTS" TC WHERE TC.CONSTRAINT_SCHEMA='PUBLIC' AND TC.TABLE_NAME='CRAZY!@#\$%^&*()_+{}[]''"TABLE'
| 3b1dd60     | true     | UNNAMED on PUBLIC.MixedTable                       | **plan**: SELECT TC."CONSTRAINT_NAME", TC."TABLE_CATALOG", TC."TABLE_SCHEMA", TC."TABLE_NAME", FALSE AS IS_DEFERRABLE, FALSE AS INITIALLY_DEFERRED, "COLUMN_LIST" FROM "INFORMATION_SCHEMA"."CONSTRAINTS" TC WHERE TC.CONSTRAINT_SCHEMA='PUBLIC' AND TC.TABLE_NAME='MixedTable'
| f406acd     | true     | UNNAMED on PUBLIC.ONLY_IN_PUBLIC                   | **plan**: SELECT TC."CONSTRAINT_NAME", TC."TABLE_CATALOG", TC."TABLE_SCHEMA", TC."TABLE_NAME", FALSE AS IS_DEFERRABLE, FALSE AS INITIALLY_DEFERRED, "COLUMN_LIST" FROM "INFORMATION_SCHEMA"."CONSTRAINTS" TC WHERE TC.CONSTRAINT_SCHEMA='PUBLIC' AND TC.TABLE_NAME='ONLY_IN_PUBLIC'
| 23962fc     | true     | UNNAMED on PUBLIC.UPPERTABLE                       | **plan**: SELECT TC."CONSTRAINT_NAME", TC."TABLE_CATALOG", TC."TABLE_SCHEMA", TC."TABLE_NAME", FALSE AS IS_DEFERRABLE, FALSE AS INITIALLY_DEFERRED, "COLUMN_LIST" FROM "INFORMATION_SCHEMA"."CONSTRAINTS" TC WHERE TC.CONSTRAINT_SCHEMA='PUBLIC' AND TC.TABLE_NAME='UPPERTABLE'
| bf7671e     | true     | UNNAMED on PUBLIC.anotherlowertable                | **plan**: SELECT TC."CONSTRAINT_NAME", TC."TABLE_CATALOG", TC."TABLE_SCHEMA", TC."TABLE_NAME", FALSE AS IS_DEFERRABLE, FALSE AS INITIALLY_DEFERRED, "COLUMN_LIST" FROM "INFORMATION_SCHEMA"."CONSTRAINTS" TC WHERE TC.CONSTRAINT_SCHEMA='PUBLIC' AND TC.TABLE_NAME='anotherlowertable'
| c4cbf81     | true     | UNNAMED on PUBLIC.crazy!@#\$%^&*()_+{}[]'"table    | **plan**: SELECT TC."CONSTRAINT_NAME", TC."TABLE_CATALOG", TC."TABLE_SCHEMA", TC."TABLE_NAME", FALSE AS IS_DEFERRABLE, FALSE AS INITIALLY_DEFERRED, "COLUMN_LIST" FROM "INFORMATION_SCHEMA"."CONSTRAINTS" TC WHERE TC.CONSTRAINT_SCHEMA='PUBLIC' AND TC.TABLE_NAME='crazy!@#\$%^&*()_+{}[]''"table'
| 1c9ade1     | true     | UNNAMED on PUBLIC.lowertable                       | **plan**: SELECT TC."CONSTRAINT_NAME", TC."TABLE_CATALOG", TC."TABLE_SCHEMA", TC."TABLE_NAME", FALSE AS IS_DEFERRABLE, FALSE AS INITIALLY_DEFERRED, "COLUMN_LIST" FROM "INFORMATION_SCHEMA"."CONSTRAINTS" TC WHERE TC.CONSTRAINT_SCHEMA='PUBLIC' AND TC.TABLE_NAME='lowertable'

# Test: "can find complex uq names with a table" #

- **connection:** h2 standard

| Permutation | Verified | uq                                                      | OPERATIONS
| :---------- | :------- | :------------------------------------------------------ | :------
| 7827370     | true     | 4TEST_uniqueconstraint on KNOWN_TABLE                   | **plan**: SELECT TC."CONSTRAINT_NAME", TC."TABLE_CATALOG", TC."TABLE_SCHEMA", TC."TABLE_NAME", FALSE AS IS_DEFERRABLE, FALSE AS INITIALLY_DEFERRED, "COLUMN_LIST" FROM "INFORMATION_SCHEMA"."CONSTRAINTS" TC WHERE TC.TABLE_NAME='KNOWN_TABLE' AND TC.CONSTRAINT_NAME='4TEST_uniqueconstraint'
| c9cf3ac     | true     | 4test_uniqueconstraint on KNOWN_TABLE                   | **plan**: SELECT TC."CONSTRAINT_NAME", TC."TABLE_CATALOG", TC."TABLE_SCHEMA", TC."TABLE_NAME", FALSE AS IS_DEFERRABLE, FALSE AS INITIALLY_DEFERRED, "COLUMN_LIST" FROM "INFORMATION_SCHEMA"."CONSTRAINTS" TC WHERE TC.TABLE_NAME='KNOWN_TABLE' AND TC.CONSTRAINT_NAME='4test_uniqueconstraint'
| b8e6ac7     | true     | ANOTHERUPPERUNIQUECONSTRAINT on KNOWN_TABLE             | **plan**: SELECT TC."CONSTRAINT_NAME", TC."TABLE_CATALOG", TC."TABLE_SCHEMA", TC."TABLE_NAME", FALSE AS IS_DEFERRABLE, FALSE AS INITIALLY_DEFERRED, "COLUMN_LIST" FROM "INFORMATION_SCHEMA"."CONSTRAINTS" TC WHERE TC.TABLE_NAME='KNOWN_TABLE' AND TC.CONSTRAINT_NAME='ANOTHERUPPERUNIQUECONSTRAINT'
| b7c312c     | true     | AnotherMixedUniqueConstraint on KNOWN_TABLE             | **plan**: SELECT TC."CONSTRAINT_NAME", TC."TABLE_CATALOG", TC."TABLE_SCHEMA", TC."TABLE_NAME", FALSE AS IS_DEFERRABLE, FALSE AS INITIALLY_DEFERRED, "COLUMN_LIST" FROM "INFORMATION_SCHEMA"."CONSTRAINTS" TC WHERE TC.TABLE_NAME='KNOWN_TABLE' AND TC.CONSTRAINT_NAME='AnotherMixedUniqueConstraint'
| 1035a52     | true     | CRAZY!@#\$%^&*()_+{}[]'"UNIQUECONSTRAINT on KNOWN_TABLE | **plan**: SELECT TC."CONSTRAINT_NAME", TC."TABLE_CATALOG", TC."TABLE_SCHEMA", TC."TABLE_NAME", FALSE AS IS_DEFERRABLE, FALSE AS INITIALLY_DEFERRED, "COLUMN_LIST" FROM "INFORMATION_SCHEMA"."CONSTRAINTS" TC WHERE TC.TABLE_NAME='KNOWN_TABLE' AND TC.CONSTRAINT_NAME='CRAZY!@#\$%^&*()_+{}[]''"UNIQUECONSTRAINT'
| fc49d2b     | true     | MixedUniqueConstraint on KNOWN_TABLE                    | **plan**: SELECT TC."CONSTRAINT_NAME", TC."TABLE_CATALOG", TC."TABLE_SCHEMA", TC."TABLE_NAME", FALSE AS IS_DEFERRABLE, FALSE AS INITIALLY_DEFERRED, "COLUMN_LIST" FROM "INFORMATION_SCHEMA"."CONSTRAINTS" TC WHERE TC.TABLE_NAME='KNOWN_TABLE' AND TC.CONSTRAINT_NAME='MixedUniqueConstraint'
| d8974a3     | true     | UPPERUNIQUECONSTRAINT on KNOWN_TABLE                    | **plan**: SELECT TC."CONSTRAINT_NAME", TC."TABLE_CATALOG", TC."TABLE_SCHEMA", TC."TABLE_NAME", FALSE AS IS_DEFERRABLE, FALSE AS INITIALLY_DEFERRED, "COLUMN_LIST" FROM "INFORMATION_SCHEMA"."CONSTRAINTS" TC WHERE TC.TABLE_NAME='KNOWN_TABLE' AND TC.CONSTRAINT_NAME='UPPERUNIQUECONSTRAINT'
| b494195     | true     | anotherloweruniqueconstraint on KNOWN_TABLE             | **plan**: SELECT TC."CONSTRAINT_NAME", TC."TABLE_CATALOG", TC."TABLE_SCHEMA", TC."TABLE_NAME", FALSE AS IS_DEFERRABLE, FALSE AS INITIALLY_DEFERRED, "COLUMN_LIST" FROM "INFORMATION_SCHEMA"."CONSTRAINTS" TC WHERE TC.TABLE_NAME='KNOWN_TABLE' AND TC.CONSTRAINT_NAME='anotherloweruniqueconstraint'
| dbf3d88     | true     | crazy!@#\$%^&*()_+{}[]'"uniqueconstraint on KNOWN_TABLE | **plan**: SELECT TC."CONSTRAINT_NAME", TC."TABLE_CATALOG", TC."TABLE_SCHEMA", TC."TABLE_NAME", FALSE AS IS_DEFERRABLE, FALSE AS INITIALLY_DEFERRED, "COLUMN_LIST" FROM "INFORMATION_SCHEMA"."CONSTRAINTS" TC WHERE TC.TABLE_NAME='KNOWN_TABLE' AND TC.CONSTRAINT_NAME='crazy!@#\$%^&*()_+{}[]''"uniqueconstraint'
| 94dc5b1     | true     | loweruniqueconstraint on KNOWN_TABLE                    | **plan**: SELECT TC."CONSTRAINT_NAME", TC."TABLE_CATALOG", TC."TABLE_SCHEMA", TC."TABLE_NAME", FALSE AS IS_DEFERRABLE, FALSE AS INITIALLY_DEFERRED, "COLUMN_LIST" FROM "INFORMATION_SCHEMA"."CONSTRAINTS" TC WHERE TC.TABLE_NAME='KNOWN_TABLE' AND TC.CONSTRAINT_NAME='loweruniqueconstraint'

# Test: "can find complex uq names without a table" #

- **connection:** h2 standard

| Permutation | Verified | uq                                                  | OPERATIONS
| :---------- | :------- | :-------------------------------------------------- | :------
| c6ef6d3     | true     | 4TEST_uniqueconstraint on UNNAMED                   | **plan**: SELECT TC."CONSTRAINT_NAME", TC."TABLE_CATALOG", TC."TABLE_SCHEMA", TC."TABLE_NAME", FALSE AS IS_DEFERRABLE, FALSE AS INITIALLY_DEFERRED, "COLUMN_LIST" FROM "INFORMATION_SCHEMA"."CONSTRAINTS" TC WHERE TC.CONSTRAINT_NAME='4TEST_uniqueconstraint'
| 81c5081     | true     | 4test_uniqueconstraint on UNNAMED                   | **plan**: SELECT TC."CONSTRAINT_NAME", TC."TABLE_CATALOG", TC."TABLE_SCHEMA", TC."TABLE_NAME", FALSE AS IS_DEFERRABLE, FALSE AS INITIALLY_DEFERRED, "COLUMN_LIST" FROM "INFORMATION_SCHEMA"."CONSTRAINTS" TC WHERE TC.CONSTRAINT_NAME='4test_uniqueconstraint'
| ad8d401     | true     | ANOTHERUPPERUNIQUECONSTRAINT on UNNAMED             | **plan**: SELECT TC."CONSTRAINT_NAME", TC."TABLE_CATALOG", TC."TABLE_SCHEMA", TC."TABLE_NAME", FALSE AS IS_DEFERRABLE, FALSE AS INITIALLY_DEFERRED, "COLUMN_LIST" FROM "INFORMATION_SCHEMA"."CONSTRAINTS" TC WHERE TC.CONSTRAINT_NAME='ANOTHERUPPERUNIQUECONSTRAINT'
| 99d03ca     | true     | AnotherMixedUniqueConstraint on UNNAMED             | **plan**: SELECT TC."CONSTRAINT_NAME", TC."TABLE_CATALOG", TC."TABLE_SCHEMA", TC."TABLE_NAME", FALSE AS IS_DEFERRABLE, FALSE AS INITIALLY_DEFERRED, "COLUMN_LIST" FROM "INFORMATION_SCHEMA"."CONSTRAINTS" TC WHERE TC.CONSTRAINT_NAME='AnotherMixedUniqueConstraint'
| 5188ffa     | true     | CRAZY!@#\$%^&*()_+{}[]'"UNIQUECONSTRAINT on UNNAMED | **plan**: SELECT TC."CONSTRAINT_NAME", TC."TABLE_CATALOG", TC."TABLE_SCHEMA", TC."TABLE_NAME", FALSE AS IS_DEFERRABLE, FALSE AS INITIALLY_DEFERRED, "COLUMN_LIST" FROM "INFORMATION_SCHEMA"."CONSTRAINTS" TC WHERE TC.CONSTRAINT_NAME='CRAZY!@#\$%^&*()_+{}[]''"UNIQUECONSTRAINT'
| 80025a3     | true     | MixedUniqueConstraint on UNNAMED                    | **plan**: SELECT TC."CONSTRAINT_NAME", TC."TABLE_CATALOG", TC."TABLE_SCHEMA", TC."TABLE_NAME", FALSE AS IS_DEFERRABLE, FALSE AS INITIALLY_DEFERRED, "COLUMN_LIST" FROM "INFORMATION_SCHEMA"."CONSTRAINTS" TC WHERE TC.CONSTRAINT_NAME='MixedUniqueConstraint'
| 8fa9a9c     | true     | UPPERUNIQUECONSTRAINT on UNNAMED                    | **plan**: SELECT TC."CONSTRAINT_NAME", TC."TABLE_CATALOG", TC."TABLE_SCHEMA", TC."TABLE_NAME", FALSE AS IS_DEFERRABLE, FALSE AS INITIALLY_DEFERRED, "COLUMN_LIST" FROM "INFORMATION_SCHEMA"."CONSTRAINTS" TC WHERE TC.CONSTRAINT_NAME='UPPERUNIQUECONSTRAINT'
| ca93e62     | true     | anotherloweruniqueconstraint on UNNAMED             | **plan**: SELECT TC."CONSTRAINT_NAME", TC."TABLE_CATALOG", TC."TABLE_SCHEMA", TC."TABLE_NAME", FALSE AS IS_DEFERRABLE, FALSE AS INITIALLY_DEFERRED, "COLUMN_LIST" FROM "INFORMATION_SCHEMA"."CONSTRAINTS" TC WHERE TC.CONSTRAINT_NAME='anotherloweruniqueconstraint'
| c6f12ef     | true     | crazy!@#\$%^&*()_+{}[]'"uniqueconstraint on UNNAMED | **plan**: SELECT TC."CONSTRAINT_NAME", TC."TABLE_CATALOG", TC."TABLE_SCHEMA", TC."TABLE_NAME", FALSE AS IS_DEFERRABLE, FALSE AS INITIALLY_DEFERRED, "COLUMN_LIST" FROM "INFORMATION_SCHEMA"."CONSTRAINTS" TC WHERE TC.CONSTRAINT_NAME='crazy!@#\$%^&*()_+{}[]''"uniqueconstraint'
| 6ba762d     | true     | loweruniqueconstraint on UNNAMED                    | **plan**: SELECT TC."CONSTRAINT_NAME", TC."TABLE_CATALOG", TC."TABLE_SCHEMA", TC."TABLE_NAME", FALSE AS IS_DEFERRABLE, FALSE AS INITIALLY_DEFERRED, "COLUMN_LIST" FROM "INFORMATION_SCHEMA"."CONSTRAINTS" TC WHERE TC.CONSTRAINT_NAME='loweruniqueconstraint'

# Test Version: "5fc9e0" #