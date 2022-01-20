/*
 * Copyright (c) 2016-2017, Cameron Moberg <Moberg@tuta.io>
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.bosstimer;

import com.google.common.collect.ImmutableMap;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import net.runelite.api.ItemID;
import net.runelite.api.NpcID;

enum Boss
{
    GENERAL_GRAARDOR(NpcID.GENERAL_GRAARDOR, 30_000, ChronoUnit.MILLIS, ItemID.PET_GENERAL_GRAARDOR),

    KRIL_TSUTSAROTH(NpcID.KRIL_TSUTSAROTH, 90_000, ChronoUnit.MILLIS, ItemID.PET_KRIL_TSUTSAROTH),
    
    KREEARRA(NpcID.KREEARRA, 30_000, ChronoUnit.MILLIS, ItemID.PET_KREEARRA),

    COMMANDER_ZILYANA(NpcID.COMMANDER_ZILYANA, 30_000, ChronoUnit.MILLIS, ItemID.PET_ZILYANA),

    CALLISTO(NpcID.CALLISTO_6609, 21_000, ChronoUnit.MILLIS, ItemID.CALLISTO_CUB),

    CHAOS_ELEMENTAL(NpcID.CHAOS_ELEMENTAL, 36_000, ChronoUnit.MILLIS, ItemID.PET_CHAOS_ELEMENTAL),

    //CHAOS_FANATIC(NpcID.CHAOS_FANATIC, 24_000, ChronoUnit.MILLIS, ItemID.ANCIENT_STAFF),

    //CRAZY_ARCHAEOLOGIST(NpcID.CRAZY_ARCHAEOLOGIST, 30, ChronoUnit.MILLIS, ItemID.FEDORA),

    KING_BLACK_DRAGON(NpcID.KING_BLACK_DRAGON, 6_000, ChronoUnit.MILLIS, ItemID.PRINCE_BLACK_DRAGON),

    SCORPIA(NpcID.SCORPIA, 18_000, ChronoUnit.MILLIS, ItemID.SCORPIAS_OFFSPRING),

    VENENATIS(NpcID.VENENATIS_6610, 18_000, ChronoUnit.MILLIS, ItemID.VENENATIS_SPIDERLING),

    //VETION(NpcID.VETION_REBORN, 30, ChronoUnit.MILLIS, ItemID.VETION_JR),

    DAGANNOTH_PRIME(NpcID.DAGANNOTH_PRIME, 72_000, ChronoUnit.MILLIS, ItemID.PET_DAGANNOTH_PRIME),

    DAGANNOTH_REX(NpcID.DAGANNOTH_REX, 72_000, ChronoUnit.MILLIS, ItemID.PET_DAGANNOTH_REX),

    DAGANNOTH_SUPREME(NpcID.DAGANNOTH_SUPREME, 72_000, ChronoUnit.MILLIS, ItemID.PET_DAGANNOTH_SUPREME),

    CORPOREAL_BEAST(NpcID.CORPOREAL_BEAST, 36_000, ChronoUnit.MILLIS, ItemID.PET_DARK_CORE),

    GIANT_MOLE(NpcID.GIANT_MOLE, 6000, ChronoUnit.MILLIS, ItemID.BABY_MOLE),

    //DERANGED_ARCHAEOLOGIST(NpcID.DERANGED_ARCHAEOLOGIST, 29400, ChronoUnit.MILLIS, ItemID.UNIDENTIFIED_LARGE_FOSSIL),

    CERBERUS(NpcID.CERBERUS, 36_000, ChronoUnit.MILLIS, ItemID.HELLPUPPY),

    //THERMONUCLEAR_SMOKE_DEVIL(NpcID.THERMONUCLEAR_SMOKE_DEVIL, 8400, ChronoUnit.MILLIS, ItemID.PET_SMOKE_DEVIL),

    KRAKEN(NpcID.KRAKEN, 7500, ChronoUnit.MILLIS, ItemID.PET_KRAKEN),

    KALPHITE_QUEEN(NpcID.KALPHITE_QUEEN_SECOND, 6_000, ChronoUnit.MILLIS, ItemID.KALPHITE_PRINCESS),

    //DUSK(NpcID.DUSK_7889, 5, ChronoUnit.MINUTES, ItemID.NOON),

    BARRELCHEST(5666, 18_000, ChronoUnit.MILLIS, 11972),

    ABYSSAL_SIRE(20886, 36_000, ChronoUnit.MILLIS, 43273),

    BANDOS_AVATAR(4540, 27_000, ChronoUnit.MILLIS, 11988),

    BORK(7134, 18_000, ChronoUnit.MILLIS, 11971),
    NEX(13447, 36_000, ChronoUnit.MILLIS, 11987),
    LIZARDMAN_SHAMAN(6766, 27_000, ChronoUnit.MILLIS, 10977),
    PHOENIX(8549, 21_000, ChronoUnit.MILLIS, 11989),
    SKOTIZO(7286, 27_000, ChronoUnit.MILLIS, 11967),
    SLASH_BASH(2060, 12_000, ChronoUnit.MILLIS, 11994),
    /*ALCHEMICAL_HYDRA(NpcID.ALCHEMICAL_HYDRA_8622, 25200, ChronoUnit.MILLIS, ItemID.IKKLE_HYDRA),
    SARACHNIS(NpcID.SARACHNIS, 10, ChronoUnit.MILLIS, ItemID.SRARACHA),
    ZALCANO(NpcID.ZALCANO_9050, 21600, ChronoUnit.MILLIS, ItemID.SMOLCANO),*/
    ;

    private static final Map<Integer, Boss> bosses;

    private final int id;
    private final Duration spawnTime;
    private final int itemSpriteId;

    static
    {
        ImmutableMap.Builder<Integer, Boss> builder = new ImmutableMap.Builder<>();

        for (Boss boss : values())
        {
            builder.put(boss.getId(), boss);
        }

        bosses = builder.build();
    }

    Boss(int id, long period, ChronoUnit unit, int itemSpriteId)
    {
        this.id = id;
        this.spawnTime = Duration.of(period, unit);
        this.itemSpriteId = itemSpriteId;
    }

    public int getId()
    {
        return id;
    }

    public Duration getSpawnTime()
    {
        return spawnTime;
    }

    public int getItemSpriteId()
    {
        return itemSpriteId;
    }

    public static Boss find(int id)
    {
        return bosses.get(id);
    }
}