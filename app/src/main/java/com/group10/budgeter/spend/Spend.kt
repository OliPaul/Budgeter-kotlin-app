package com.group10.budgeter.spend

import java.util.*

data class Spend(var spendTitle: String, var spendAmount: Double, var spendCategory: String, var spendComment: String, var spendDate: Date, var userID: String);
