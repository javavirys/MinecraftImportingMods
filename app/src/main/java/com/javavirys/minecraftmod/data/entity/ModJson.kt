/*
 * Copyright 2021 Vitaliy Sychov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.javavirys.minecraftmod.data.entity

import com.google.gson.annotations.SerializedName

//            "kusf_qx": "M",
//            "kusff2": "x1589476126_boomerangs-addon-114_2.jpg.pagespeed.ic.C9KFkOivoF.jpg",
//            "kusf_vmvie": "tIp1G2R8VjI7WEfNpDPNQVFTD,QvcioCRYOwZ_7UA-lk,L.GSt4cp-gotWsXYhpT,zqkuQlhik,WCUp",
//            "kusfd4": "Boomerang [1.14-1.16]",
//            "kusft3": "1589476225_boomerangs.mcaddon",
//            "kusf_qvl": "JqGVzIf R7Dyh8ocD.DJYco2PKO_pf2AbVJguqEN-v0yLpOSKBBP",
//            "kusf_6k_6": "9ZDLey",
//            "kusf_3h": "gyauKOuH 9p9rrPrRtKybyW.K9DcLQk77v7OyT8llgDbmDULxpxx7suxfelL4jRsu0gNSBSGQX6a2ydYQHBivjRq9prULwlS8HN6Tc-.FPdyQ14M_reEuVkF9rtTSN_atYoV8BQ7P_j8WWOe geqQ,J",
//            "kusfi1": "Boomerangs is a game mod for Android that will add a new type of weapon. The weapon is called \"Boomerang\". Its essence lies in the fact that the boomerang can be thrown, it will inflict damage on the enemy, after which it will return to the player. So you can throw a boomerang until it runs out of durability. By the way, if you throw the boomerang and hit the block, it will return back to the player and not get stuck. There are several types of boomerangs, including special types, for example, \"TNT-boomerang\".",
//            "kusf_b": "CLVDdUAc7f,weLgbHqeJmEZ7ACpF4dCqvHvfcpsX30,.1eRynjnQyyr.glvhM-3WYigZBpVzDI.MCvnaCasjouvn8Q-sia0ZxOkCpYX7Em25sIGRPig,JCQZZ5vfWT4.SMJlqm5UHbPeMR1m0YBe-F1U,PsQEjXn6X"


data class ModJson(
    @SerializedName("kusfd4") val name: String,
    @SerializedName("kusfi1") val description: String,
    @SerializedName("kusft3") val addonName: String,
    @SerializedName("kusff2") val imageName: String,
)
