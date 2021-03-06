/*
 * Copyright 2011 The Apache Software Foundation
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.codefollower.lealone.test.benchmark;

public class BenchReadForPseudoDistributedMode extends BenchRead {

    public static void main(String[] args) throws Exception {
        new BenchReadForPseudoDistributedMode(10000, 20000).run();
    }

    public BenchReadForPseudoDistributedMode(int startKey, int endKey) {
        super("BenchReadForPseudoDistributedMode", startKey, endKey);
    }

    @Override
    public void createTable() throws Exception {
        stmt.executeUpdate("CREATE HBASE TABLE IF NOT EXISTS " + tableName + " (" //
                + "SPLIT KEYS('RK15000'), " //预分region
                + "COLUMN FAMILY cf(id int, name varchar(500), age long, salary double))");
    }
}
