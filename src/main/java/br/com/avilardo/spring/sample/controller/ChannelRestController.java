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
package br.com.avilardo.spring.sample.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.avilardo.spring.sample.model.Channel;



@Controller
@Api(value = "Channels")
@RequestMapping("/channels")
public class ChannelRestController {

	private static List<Channel> channelList;
	
	@ApiOperation(value = "get a list of channels", response = Channel.class, notes = "Returns all channels in cache")
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<Channel> listAllChannels() {
    	return ChannelRestController.getChannelList();
    }

	@ApiOperation(value = "get a channel by id", response = Channel.class, notes = "Returns a specific channel")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Channel lookupChannelById(@ApiParam(value = "The id of the channel to return") @PathVariable("id") Integer id) {
    	Channel c = null;
		try {
			c = ChannelRestController.getChannelList().get(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	if(c == null){
    		c = new Channel("N/A", "Not found");
    	}
        return c;
    }
	
	@ApiOperation(value = "delete a channel by id", notes = "Remove a specific channel from cache")
	@RequestMapping(value = { "/{id}" }, method = RequestMethod.DELETE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void deleteChannel(@ApiParam(value = "The id of the channel to return") @PathVariable("id") Integer id) {
		ChannelRestController.getChannelList().remove(id.intValue());
    }
	
	@ApiOperation(value = "create a new channel", response = Channel.class, notes = "Create a new channel in cache")
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Channel createChannel(@ApiParam(value = "The channel to be created") @RequestBody Channel channel) {
        ChannelRestController.getChannelList().add(channel);
        return channel;
    }
	
	private static List<Channel> getChannelList() {
		if(channelList == null){
			channelList = new ArrayList<Channel>();
			channelList.add(new Channel("viva", "descViva"));
			channelList.add(new Channel("off", "descOff"));
			channelList.add(new Channel("bis", "descBis"));
	   }
		return channelList;
	}
}
