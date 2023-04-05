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