/*
 * JBoss, Home of Professional Open Source
 * Copyright 2014, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.com.globosat.spring.sample.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.globosat.spring.sample.model.Channel;
import br.com.globosat.spring.sample.model.Member;

@Controller
@Api(value = "Members")
@RequestMapping("/members")
public class MemberRestController {

	@ApiOperation(value = "get a list of members", response = Channel.class, notes = "Returns all members in cache")
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<Member> listAllMembers() {
    	List<Member> list = new ArrayList<Member>();
    	list.add(new Member("Andre", "Vilardo"));
    	list.add(new Member("Marcia", "Miranda"));
    	list.add(new Member("Adriana", "Lopes"));
        return list;
    }

	@ApiOperation(value = "get a channel by id", response = Channel.class, notes = "Returns a specific channel")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Member lookupMemberById(@PathVariable("id") Long id) {
        return new Member("Andre", "Vilardo");
    }
}
