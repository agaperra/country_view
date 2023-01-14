package com.agaperra.countryview.domain.use_case

import android.util.Log
import com.agaperra.countryview.data.dto.country_list.Country
import com.agaperra.countryview.domain.repository.CountryListRepository
import com.agaperra.countryview.presentation.ui.country.CountryViewModel.ContentEvent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

/**
 * Get country list
 *
 * @property countryListRepository
 * @constructor Create empty Get country list
 */
class GetCountryList @Inject constructor(
    private val countryListRepository: CountryListRepository,
) {

    operator fun invoke(): Flow<ContentEvent<List<Country>>> = flow {
        try {
            emit(ContentEvent.Loading())
            val result = countryListRepository.getCountryList()
            if (result == null) {
                emit(ContentEvent.Error("Data is null"))
            } else {
                emit(ContentEvent.Success(result))
            }
        } catch (exception: HttpException) {
            emit(ContentEvent.Error(exception.message()))
        } catch (exception: Exception) {
            emit(ContentEvent.Error("Unknown error: ${exception.message}"))
        }
    }

}