### 查看地图轮换

url: https://api.mozambiquehe.re/bridge?auth=YOUR_API_KEY&uid=PLAYER_UID&platform=PLATFORM

response:
```json
{
  "battle_royale": {
    "current": {
      "start": 1680519600,
      "end": 1680525000,
      "readableDate_start": "2023-04-03 11:00:00",
      "readableDate_end": "2023-04-03 12:30:00",
      "map": "Broken Moon",
      "code": "broken_moon_rotation",
      "DurationInSecs": 5400,
      "DurationInMinutes": 90,
      "asset": "https:\/\/apexlegendsstatus.com\/assets\/maps\/Broken_Moon.png",
      "remainingSecs": 4212,
      "remainingMins": 70,
      "remainingTimer": "01:10:12"
    },
    "next": {
      "start": 1680525000,
      "end": 1680528600,
      "readableDate_start": "2023-04-03 12:30:00",
      "readableDate_end": "2023-04-03 13:30:00",
      "map": "Olympus",
      "code": "olympus_rotation",
      "DurationInSecs": 3600,
      "DurationInMinutes": 60,
      "asset": "https:\/\/apexlegendsstatus.com\/assets\/maps\/Olympus.png"
    }
  },
  "arenas": {
    "current": {
      "start": 1680520500,
      "end": 1680521400,
      "readableDate_start": "2023-04-03 11:15:00",
      "readableDate_end": "2023-04-03 11:30:00",
      "map": "Encore",
      "code": "arenas_encore",
      "DurationInSecs": 900,
      "DurationInMinutes": 15,
      "asset": "https:\/\/apexlegendsstatus.com\/assets\/maps\/Arena_Encore.png",
      "remainingSecs": 612,
      "remainingMins": 10,
      "remainingTimer": "00:10:12"
    },
    "next": {
      "start": 1680521400,
      "end": 1680522300,
      "readableDate_start": "2023-04-03 11:30:00",
      "readableDate_end": "2023-04-03 11:45:00",
      "map": "Overflow",
      "code": "arenas_overflow",
      "DurationInSecs": 900,
      "DurationInMinutes": 15,
      "asset": "https:\/\/apexlegendsstatus.com\/assets\/maps\/Arena_Overflow.png"
    }
  },
  "ranked": {
    "current": {
      "start": 1680454800,
      "end": 1680541200,
      "readableDate_start": "2023-04-02 17:00:00",
      "readableDate_end": "2023-04-03 17:00:00",
      "map": "Broken Moon",
      "code": "broken_moon_rotation",
      "DurationInSecs": 86400,
      "DurationInMinutes": 1440,
      "asset": "https:\/\/apexlegendsstatus.com\/assets\/maps\/Broken_Moon.png",
      "remainingSecs": 20412,
      "remainingMins": 340,
      "remainingTimer": "05:40:12"
    },
    "next": {
      "start": 1680541200,
      "end": 1680627600,
      "readableDate_start": "2023-04-03 17:00:00",
      "readableDate_end": "2023-04-04 17:00:00",
      "map": "Olympus",
      "code": "olympus_rotation",
      "DurationInSecs": 86400,
      "DurationInMinutes": 1440,
      "asset": "https:\/\/apexlegendsstatus.com\/assets\/maps\/Olympus.png"
    }
  },
  "arenasRanked": {
    "current": {
      "start": 1680520500,
      "end": 1680521400,
      "readableDate_start": "2023-04-03 11:15:00",
      "readableDate_end": "2023-04-03 11:30:00",
      "map": "Encore",
      "code": "arenas_encore",
      "DurationInSecs": 900,
      "DurationInMinutes": 15,
      "asset": "https:\/\/apexlegendsstatus.com\/assets\/maps\/Arena_Encore.png",
      "remainingSecs": 612,
      "remainingMins": 10,
      "remainingTimer": "00:10:12"
    },
    "next": {
      "start": 1680521400,
      "end": 1680522300,
      "readableDate_start": "2023-04-03 11:30:00",
      "readableDate_end": "2023-04-03 11:45:00",
      "map": "Overflow",
      "code": "arenas_overflow",
      "DurationInSecs": 900,
      "DurationInMinutes": 15,
      "asset": "https:\/\/apexlegendsstatus.com\/assets\/maps\/Arena_Overflow.png"
    }
  },
  "ltm": {
    "current": {
      "start": 1680520500,
      "end": 1680521400,
      "readableDate_start": "2023-04-03 11:15:00",
      "readableDate_end": "2023-04-03 11:30:00",
      "map": "Fragment",
      "code": "freedm_gungame_fragment",
      "DurationInSecs": 900,
      "DurationInMinutes": 15,
      "isActive": true,
      "eventName": "Gun Run",
      "asset": "https:\/\/apexlegendsstatus.com\/assets\/maps\/",
      "remainingSecs": 612,
      "remainingMins": 10,
      "remainingTimer": "00:10:12"
    },
    "next": {
      "start": 1680521400,
      "end": 1680522300,
      "readableDate_start": "2023-04-03 11:30:00",
      "readableDate_end": "2023-04-03 11:45:00",
      "map": "Caustic",
      "code": "control_canyonlands_caustic",
      "DurationInSecs": 900,
      "DurationInMinutes": 15,
      "isActive": true,
      "eventName": "Control",
      "asset": "https:\/\/apexlegendsstatus.com\/assets\/maps\/"
    }
  }
}
```

### 查看制造器

url: https://api.mozambiquehe.re/crafting?auth=$APEX_KEY

response:
```json
[
    {
        "bundle": "shredder_bundle",
        "start": 1680458400,
        "end": 1680544800,
        "startDate": "2023-04-02 18:00:00",
        "endDate": "2023-04-03 18:00:00",
        "bundleType": "daily",
        "bundleContent": [
            {
                "item": "barrel_stabilizer_l3",
                "cost": 25,
                "itemType": {
                    "name": "barrel_stabilizer",
                    "rarity": "Epic",
                    "asset": "https:\/\/legion.apexlegendsstatus.com\/cache\/cd0b95161991ff01d71542ea87659ce4.png",
                    "rarityHex": "#B200FF"
                }
            },
            {
                "item": "hopup_turbocharger",
                "cost": 45,
                "itemType": {
                    "name": "turbocharger",
                    "rarity": "Legendary",
                    "asset": "https:\/\/legion.apexlegendsstatus.com\/cache\/71e93e12f215e1f9eea5b79b9ad4d789.png",
                    "rarityHex": "#FFD800"
                }
            }
        ]
    },
    {
        "bundle": "equipment_bundle_2",
        "start": 1680458400,
        "end": 1681063200,
        "startDate": "2023-04-02 18:00:00",
        "endDate": "2023-04-09 18:00:00",
        "bundleType": "weekly",
        "bundleContent": [
            {
                "item": "backpack_pickup_lv3",
                "cost": 75,
                "itemType": {
                    "name": "backpack",
                    "rarity": "Epic",
                    "asset": "https:\/\/legion.apexlegendsstatus.com\/cache\/5a47e172428bc5ed5f50895e85f0a031.png",
                    "rarityHex": "#B200FF"
                }
            },
            {
                "item": "helmet_pickup_lv3",
                "cost": 30,
                "itemType": {
                    "name": "helmet",
                    "rarity": "Epic",
                    "asset": "https:\/\/legion.apexlegendsstatus.com\/cache\/08122ea022170da97f0eb6181a36f61f.png",
                    "rarityHex": "#B200FF"
                }
            }
        ]
    },
    {
        "bundle": "weapon_one",
        "bundleType": "permanent",
        "bundleContent": [
            {
                "item": "mp_weapon_dmr",
                "cost": 30,
                "itemType": {
                    "name": "longbow",
                    "rarity": "Common",
                    "asset": "https:\/\/legion.apexlegendsstatus.com\/cache\/329f07e56a833cfb48d258fb6943eb3c.png",
                    "rarityHex": "#808080"
                }
            }
        ]
    },
    {
        "bundle": "weapon_two",
        "bundleType": "permanent",
        "bundleContent": [
            {
                "item": "mp_weapon_volt",
                "cost": 30,
                "itemType": {
                    "name": "volt",
                    "rarity": "Common",
                    "asset": "https:\/\/legion.apexlegendsstatus.com\/cache\/car_override.png",
                    "rarityHex": "#808080"
                }
            }
        ]
    },
    {
        "bundle": "health_pickup",
        "bundleType": "permanent",
        "bundleContent": [
            {
                "item": "health_pickup_health_large",
                "cost": 15,
                "itemType": {
                    "name": "med_kit",
                    "rarity": "Rare",
                    "asset": "https:\/\/legion.apexlegendsstatus.com\/cache\/6fc0b73490114ec75a8e564179f3ab68.png",
                    "rarityHex": "#0094FF"
                }
            }
        ]
    },
    {
        "bundle": "shield_pickup",
        "bundleType": "permanent",
        "bundleContent": [
            {
                "item": "health_pickup_combo_large",
                "cost": 20,
                "itemType": {
                    "name": "large_shield_cell",
                    "rarity": "Rare",
                    "asset": "https:\/\/legion.apexlegendsstatus.com\/cache\/30e855bb61c983f0407f4ad32a3dff58.png",
                    "rarityHex": "#0094FF"
                }
            }
        ]
    },
    {
        "bundle": "ammo",
        "bundleType": "permanent",
        "bundleContent": [
            {
                "item": "bullet",
                "cost": 10,
                "itemType": {
                    "name": "ammo",
                    "rarity": "Common",
                    "asset": "https:\/\/legion.apexlegendsstatus.com\/cache\/0f8ac57cbf0db1163f77fcef09f9fb2c.png",
                    "rarityHex": "#808080"
                }
            },
            {
                "item": "special",
                "cost": 10,
                "itemType": {
                    "name": "ammo",
                    "rarity": "Common",
                    "asset": "https:\/\/legion.apexlegendsstatus.com\/cache\/0f8ac57cbf0db1163f77fcef09f9fb2c.png",
                    "rarityHex": "#808080"
                }
            },
            {
                "item": "shotgun",
                "cost": 10,
                "itemType": {
                    "name": "ammo",
                    "rarity": "Common",
                    "asset": "https:\/\/legion.apexlegendsstatus.com\/cache\/0f8ac57cbf0db1163f77fcef09f9fb2c.png",
                    "rarityHex": "#808080"
                }
            },
            {
                "item": "highcal",
                "cost": 10,
                "itemType": {
                    "name": "ammo",
                    "rarity": "Common",
                    "asset": "https:\/\/legion.apexlegendsstatus.com\/cache\/0f8ac57cbf0db1163f77fcef09f9fb2c.png",
                    "rarityHex": "#808080"
                }
            },
            {
                "item": "sniper",
                "cost": 10,
                "itemType": {
                    "name": "ammo",
                    "rarity": "Common",
                    "asset": "https:\/\/legion.apexlegendsstatus.com\/cache\/0f8ac57cbf0db1163f77fcef09f9fb2c.png",
                    "rarityHex": "#808080"
                }
            },
            {
                "item": "arrows",
                "cost": 10,
                "itemType": {
                    "name": "ammo",
                    "rarity": "Common",
                    "asset": "https:\/\/legion.apexlegendsstatus.com\/cache\/0f8ac57cbf0db1163f77fcef09f9fb2c.png",
                    "rarityHex": "#808080"
                }
            }
        ]
    },
    {
        "bundle": "evo",
        "bundleType": "permanent",
        "bundleContent": [
            {
                "item": "evo_points",
                "cost": 50,
                "itemType": {
                    "name": "evo_armor",
                    "rarity": "Common",
                    "asset": "https:\/\/legion.apexlegendsstatus.com\/cache\/4445aea4337022d3694f5d3b07940a6b.png",
                    "rarityHex": "#808080"
                }
            }
        ]
    }
]       
```

### 查找玩家信息

response:
```json
{
    "global": {
        "name": "",
        "uid": 1007993482882,
        "avatar": "",
        "platform": "PC",
        "level": 158,
        "toNextLevelPercent": 88,
        "internalUpdateCount": 2634,
        "bans": {
            "isActive": false,
            "remainingSeconds": 0,
            "last_banReason": "COMPETITIVE_DODGE_COOLDOWN"
        },
        "rank": {
            "rankScore": 0,
            "rankName": "Unranked",
            "rankDiv": 0,
            "ladderPosPlatform": -1,
            "rankImg": "https:\/\/api.mozambiquehe.re\/assets\/ranks\/unranked4.png",
            "rankedSeason": "season16_split_2"
        },
        "arena": {
            "rankScore": 0,
            "rankName": "Unranked",
            "rankDiv": 0,
            "ladderPosPlatform": -1,
            "rankImg": "https:\/\/api.mozambiquehe.re\/assets\/ranks\/unranked4.png",
            "rankedSeason": "arenas16_split_2"
        },
        "battlepass": {
            "level": "-1",
            "history": {
                "season1": -1,
                "season2": -1,
                "season3": -1,
                "season4": -1,
                "season5": -1,
                "season6": -1,
                "season7": -1,
                "season8": -1,
                "season9": -1,
                "season10": -1,
                "season11": 1,
                "season12": -1,
                "season13": -1,
                "season14": -1
            }
        },
        "internalParsingVersion": 2,
        "badges": [
            {
                "name": "Stop Asian Hate",
                "value": 0
            },
            {
                "name": "Pride",
                "value": 0
            },
            {
                "name": "Black Lives Matter",
                "value": 0
            }
        ],
        "levelPrestige": 0
    },
    "realtime": {
        "lobbyState": "open",
        "isOnline": 0,
        "isInGame": 0,
        "canJoin": 0,
        "partyFull": 0,
        "selectedLegend": "Bloodhound",
        "currentState": "offline",
        "currentStateSinceTimestamp": -1,
        "currentStateAsText": "Offline"
    },
    "legends": {
        "selected": {
            "LegendName": "Bloodhound",
            "data": [
                {
                    "name": "BR Kills",
                    "value": 523,
                    "key": "kills",
                    "global": false
                },
                {
                    "name": "Scout of Action",
                    "value": 110,
                    "key": "scout_of_action_targets_hit",
                    "global": true
                },
                {
                    "name": "BR Damage",
                    "value": 189254,
                    "key": "damage",
                    "global": false
                }
            ],
            "gameInfo": {
                "skin": "Night Raver",
                "skinRarity": "Epic",
                "frame": "Summer Slasher",
                "frameRarity": "Epic",
                "pose": "On Target",
                "poseRarity": "Epic",
                "intro": "The hunter the gods have sent",
                "introRarity": "Rare",
                "badges": [
                    {
                        "name": "Apex Predator",
                        "value": 0,
                        "category": "Bloodhound"
                    },
                    {
                        "name": "Assassin",
                        "value": 3,
                        "category": "Bloodhound"
                    },
                    {
                        "name": "Squad Wipe",
                        "value": 0,
                        "category": "Bloodhound"
                    }
                ]
            },
            "ImgAssets": {
                "icon": "https:\/\/api.mozambiquehe.re\/assets\/icons\/bloodhound.png",
                "banner": "https:\/\/api.mozambiquehe.re\/assets\/banners\/bloodhound.jpg"
            }
        },
        "all": {
            "Global": {
                "data": [
                    {
                        "name": "Scout of Action",
                        "value": 110,
                        "key": "scout_of_action_targets_hit",
                        "rank": {
                            "rankPos": 49459,
                            "topPercent": 6.81
                        },
                        "rankPlatformSpecific": {
                            "rankPos": 35248,
                            "topPercent": 9.89
                        }
                    }
                ],
                "ImgAssets": {
                    "icon": "https:\/\/api.mozambiquehe.re\/assets\/icons\/global.png",
                    "banner": "https:\/\/api.mozambiquehe.re\/assets\/banners\/global.jpg"
                }
            },
            "Revenant": {
                "ImgAssets": {
                    "icon": "https:\/\/api.mozambiquehe.re\/assets\/icons\/revenant.png",
                    "banner": "https:\/\/api.mozambiquehe.re\/assets\/banners\/revenant.jpg"
                }
            },
            "Crypto": {
                "data": [
                    {
                        "name": "BR Kills",
                        "value": 0,
                        "key": "kills",
                        "rank": {
                            "rankPos": "NOT_CALCULATED_YET",
                            "topPercent": "NOT_CALCULATED_YET"
                        },
                        "rankPlatformSpecific": {
                            "rankPos": "NOT_CALCULATED_YET",
                            "topPercent": "NOT_CALCULATED_YET"
                        }
                    }
                ],
                "ImgAssets": {
                    "icon": "https:\/\/api.mozambiquehe.re\/assets\/icons\/crypto.png",
                    "banner": "https:\/\/api.mozambiquehe.re\/assets\/banners\/crypto.jpg"
                }
            },
            "Horizon": {
                "ImgAssets": {
                    "icon": "https:\/\/api.mozambiquehe.re\/assets\/icons\/horizon.png",
                    "banner": "https:\/\/api.mozambiquehe.re\/assets\/banners\/horizon.jpg"
                }
            },
            "Gibraltar": {
                "ImgAssets": {
                    "icon": "https:\/\/api.mozambiquehe.re\/assets\/icons\/gibraltar.png",
                    "banner": "https:\/\/api.mozambiquehe.re\/assets\/banners\/gibraltar.jpg"
                }
            },
            "Wattson": {
                "ImgAssets": {
                    "icon": "https:\/\/api.mozambiquehe.re\/assets\/icons\/wattson.png",
                    "banner": "https:\/\/api.mozambiquehe.re\/assets\/banners\/wattson.jpg"
                }
            },
            "Fuse": {
                "ImgAssets": {
                    "icon": "https:\/\/api.mozambiquehe.re\/assets\/icons\/fuse.png",
                    "banner": "https:\/\/api.mozambiquehe.re\/assets\/banners\/fuse.jpg"
                }
            },
            "Bangalore": {
                "ImgAssets": {
                    "icon": "https:\/\/api.mozambiquehe.re\/assets\/icons\/bangalore.png",
                    "banner": "https:\/\/api.mozambiquehe.re\/assets\/banners\/bangalore.jpg"
                }
            },
            "Wraith": {
                "ImgAssets": {
                    "icon": "https:\/\/api.mozambiquehe.re\/assets\/icons\/wraith.png",
                    "banner": "https:\/\/api.mozambiquehe.re\/assets\/banners\/wraith.jpg"
                }
            },
            "Octane": {
                "ImgAssets": {
                    "icon": "https:\/\/api.mozambiquehe.re\/assets\/icons\/octane.png",
                    "banner": "https:\/\/api.mozambiquehe.re\/assets\/banners\/octane.jpg"
                }
            },
            "Bloodhound": {
                "data": [
                    {
                        "name": "BR Kills",
                        "value": 523,
                        "key": "kills",
                        "rank": {
                            "rankPos": 908907,
                            "topPercent": 15.44
                        },
                        "rankPlatformSpecific": {
                            "rankPos": 309232,
                            "topPercent": 15.33
                        }
                    },
                    {
                        "name": "BR Damage",
                        "value": 189254,
                        "key": "damage",
                        "rank": {
                            "rankPos": 690195,
                            "topPercent": 32.41
                        },
                        "rankPlatformSpecific": {
                            "rankPos": 247391,
                            "topPercent": 32.83
                        }
                    }
                ],
                "gameInfo": {
                    "badges": [
                        {
                            "name": "Apex Predator",
                            "value": 0
                        },
                        {
                            "name": "Assassin",
                            "value": 0
                        },
                        {
                            "name": "Squad Wipe",
                            "value": 0
                        }
                    ]
                },
                "ImgAssets": {
                    "icon": "https:\/\/api.mozambiquehe.re\/assets\/icons\/bloodhound.png",
                    "banner": "https:\/\/api.mozambiquehe.re\/assets\/banners\/bloodhound.jpg"
                }
            },
            "Caustic": {
                "data": [
                    {
                        "name": "BR Kills",
                        "value": 0,
                        "key": "kills",
                        "rank": {
                            "rankPos": "NOT_CALCULATED_YET",
                            "topPercent": "NOT_CALCULATED_YET"
                        },
                        "rankPlatformSpecific": {
                            "rankPos": "NOT_CALCULATED_YET",
                            "topPercent": "NOT_CALCULATED_YET"
                        }
                    }
                ],
                "ImgAssets": {
                    "icon": "https:\/\/api.mozambiquehe.re\/assets\/icons\/caustic.png",
                    "banner": "https:\/\/api.mozambiquehe.re\/assets\/banners\/caustic.jpg"
                }
            },
            "Lifeline": {
                "gameInfo": {
                    "badges": [
                        {
                            "name": "Squad Wipe",
                            "value": 0
                        }
                    ]
                },
                "ImgAssets": {
                    "icon": "https:\/\/api.mozambiquehe.re\/assets\/icons\/lifeline.png",
                    "banner": "https:\/\/api.mozambiquehe.re\/assets\/banners\/lifeline.jpg"
                }
            },
            "Pathfinder": {
                "data": [
                    {
                        "name": "Grapple: Travel distance",
                        "value": 15969,
                        "key": "grapple_travel_distance",
                        "rank": {
                            "rankPos": 648556,
                            "topPercent": 73.16
                        },
                        "rankPlatformSpecific": {
                            "rankPos": 259475,
                            "topPercent": 76.88
                        }
                    }
                ],
                "gameInfo": {
                    "badges": [
                        {
                            "name": "Apex Pathfinder",
                            "value": 0
                        }
                    ]
                },
                "ImgAssets": {
                    "icon": "https:\/\/api.mozambiquehe.re\/assets\/icons\/pathfinder.png",
                    "banner": "https:\/\/api.mozambiquehe.re\/assets\/banners\/pathfinder.jpg"
                }
            },
            "Loba": {
                "ImgAssets": {
                    "icon": "https:\/\/api.mozambiquehe.re\/assets\/icons\/loba.png",
                    "banner": "https:\/\/api.mozambiquehe.re\/assets\/banners\/loba.jpg"
                }
            },
            "Mirage": {
                "ImgAssets": {
                    "icon": "https:\/\/api.mozambiquehe.re\/assets\/icons\/mirage.png",
                    "banner": "https:\/\/api.mozambiquehe.re\/assets\/banners\/mirage.jpg"
                }
            },
            "Rampart": {
                "ImgAssets": {
                    "icon": "https:\/\/api.mozambiquehe.re\/assets\/icons\/rampart.png",
                    "banner": "https:\/\/api.mozambiquehe.re\/assets\/banners\/rampart.jpg"
                }
            },
            "Valkyrie": {
                "data": [
                    {
                        "name": "BR Kills",
                        "value": 10,
                        "key": "kills",
                        "rank": {
                            "rankPos": 2836182,
                            "topPercent": 80.35
                        },
                        "rankPlatformSpecific": {
                            "rankPos": 921955,
                            "topPercent": 88.87
                        }
                    }
                ],
                "ImgAssets": {
                    "icon": "https:\/\/api.mozambiquehe.re\/assets\/icons\/valkyrie.png",
                    "banner": "https:\/\/api.mozambiquehe.re\/assets\/banners\/valkyrie.jpg"
                }
            },
            "Seer": {
                "data": [
                    {
                        "name": "BR Kills",
                        "value": 325,
                        "key": "kills",
                        "rank": {
                            "rankPos": 199988,
                            "topPercent": 8.64
                        },
                        "rankPlatformSpecific": {
                            "rankPos": 92396,
                            "topPercent": 11.65
                        }
                    },
                    {
                        "name": "BR Damage",
                        "value": 109035,
                        "key": "specialEvent_damage",
                        "rank": {
                            "rankPos": 161451,
                            "topPercent": 17.79
                        },
                        "rankPlatformSpecific": {
                            "rankPos": 78601,
                            "topPercent": 22.46
                        }
                    }
                ],
                "gameInfo": {
                    "badges": [
                        {
                            "name": "Apex Predator",
                            "value": 0
                        },
                        {
                            "name": "Seer's Wrath",
                            "value": 0
                        },
                        {
                            "name": "Squad Wipe",
                            "value": 0
                        },
                        {
                            "name": "Assassin",
                            "value": 0
                        }
                    ]
                },
                "ImgAssets": {
                    "icon": "https:\/\/api.mozambiquehe.re\/assets\/icons\/seer.png",
                    "banner": "https:\/\/api.mozambiquehe.re\/assets\/banners\/seer.jpg"
                }
            },
            "Ash": {
                "ImgAssets": {
                    "icon": "https:\/\/api.mozambiquehe.re\/assets\/icons\/ash.png",
                    "banner": "https:\/\/api.mozambiquehe.re\/assets\/banners\/ash.jpg"
                }
            },
            "Mad Maggie": {
                "ImgAssets": {
                    "icon": "https:\/\/api.mozambiquehe.re\/assets\/icons\/mad maggie.png",
                    "banner": "https:\/\/api.mozambiquehe.re\/assets\/banners\/mad maggie.jpg"
                }
            },
            "Newcastle": {
                "ImgAssets": {
                    "icon": "https:\/\/api.mozambiquehe.re\/assets\/icons\/newcastle.png",
                    "banner": "https:\/\/api.mozambiquehe.re\/assets\/banners\/newcastle.jpg"
                }
            },
            "Vantage": {
                "ImgAssets": {
                    "icon": "https:\/\/api.mozambiquehe.re\/assets\/icons\/vantage.png",
                    "banner": "https:\/\/api.mozambiquehe.re\/assets\/banners\/vantage.jpg"
                }
            },
            "Catalyst": {
                "ImgAssets": {
                    "icon": "https:\/\/api.mozambiquehe.re\/assets\/icons\/catalyst.png",
                    "banner": "https:\/\/api.mozambiquehe.re\/assets\/banners\/catalyst.jpg"
                }
            }
        }
    },
    "mozambiquehere_internal": {
        "isNewToDB": false,
        "claimedBy": "1680620586",
        "APIAccessType": "BASIC",
        "ClusterID": "3",
        "rate_limit": {
            "max_per_second": 2,
            "current_req": null
        },
        "clusterSrv": "MAIN-CLUSTER-2"
    },
    "ALS": {
        "isALSDataEnabled": false
    },
    "total": {
        "scout_of_action_targets_hit": {
            "name": "Scout of Action",
            "value": 110
        },
        "kills": {
            "name": "BR Kills",
            "value": 858
        },
        "damage": {
            "name": "BR Damage",
            "value": 189254
        },
        "grapple_travel_distance": {
            "name": "Grapple: Travel distance",
            "value": 15969
        },
        "specialEvent_damage": {
            "name": "BR Damage",
            "value": 109035
        },
        "kd": {
            "value": "-1",
            "name": "KD"
        }
    }
}
```