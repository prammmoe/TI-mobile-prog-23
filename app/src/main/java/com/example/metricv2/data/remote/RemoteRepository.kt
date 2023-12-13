package com.example.metricv2.data.remote



class RemoteRepository(private val apiService: ApiService) {
    suspend fun getRandomFood() = apiService.getRandomFood()
}

//    private var randomFoodLiveData = MutableLiveData<Meal>()
//
//    fun getRandomFood() {
//        RetrofitInstance.api.getRandomFood().enqueue(object : Callback<RandomFoodList> {
//            override fun onResponse(
//                call: Call<RandomFoodList>,
//                response: Response<RandomFoodList>
//            ) {
//                if(response.body() != null) {
//                    val randomFood: Meal = response.body()!!.meals[0]
//                    randomFoodLiveData.value = randomFood
//                } else {
//                    return
//                }
//            }
//
//            override fun onFailure(call: Call<RandomFoodList>, t: Throwable) {
//                Log.d("HomeFragment", t.message.toString())
//            }
//        })
//    }
//
//    fun observeRandomFoodLiveData():LiveData<Meal>{
//        return randomFoodLiveData
//    }