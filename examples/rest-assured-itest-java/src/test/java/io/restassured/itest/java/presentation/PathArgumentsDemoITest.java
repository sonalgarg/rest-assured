/*
 * Copyright 2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.restassured.itest.java.presentation;

import io.restassured.itest.java.support.WithJetty;
import org.junit.Test;

import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.withArgs;
import static org.hamcrest.Matchers.endsWith;

public class PathArgumentsDemoITest extends WithJetty {

    @Test
    public void pathArgumentsDemo() throws Exception {
        expect().
                rootPath("rss.channel.item[%d].enclosure.@url").
                body(withArgs(0), endsWith("somejpg.jpg")).
                body(withArgs(1), endsWith("someotherjpg.jpg")).
        when().
                get("/bigRss");
    }
}
