package net.runelite.api.events;
/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
import lombok.Value;

/**
 * An event where a command has been used in the chat.
 * <p>
 * Commands are triggered by using the "::" prefix before a chat message. The
 * structure of a command is "::[name] [args..]" where "[name]" is the name
 * of the command that is set in the command field, and args are (optional)
 * words entered that are separated by spaces.
 * <p>
 * Typing in "::" with no additional characters will treat the message as normal
 * and pass it along to the public chat.
 * <p>
 * Note that having a space as the first character after the command trigger will
 * set the command field to an empty string. For example, the message ":: hello world!"
 * will set command to "" and arguments to ["hello", "world!"].
 */
@Value
public class CommandExecuted
{
	/**
	 * The name of the command entered.
	 */
	private String command;
	/**
	 * The command arguments that have been entered.
	 */
	private String[] arguments;
}
