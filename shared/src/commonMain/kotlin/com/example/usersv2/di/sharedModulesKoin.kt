package com.example.usersv2.di

private val sharedModules = listOf(
    dataModule,
    getViewModelByPlatform()
)

fun getSharedModules() = sharedModules