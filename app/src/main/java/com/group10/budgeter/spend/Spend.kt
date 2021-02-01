package com.group10.budgeter.spend

import java.util.*

data class Spend(val spendTitle: String, val spendAmount: Double, val spendCategory: String, val spendComment: String, val spendDate: Date, val userID: String);
