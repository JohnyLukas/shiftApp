package com.example.shiftapp.domain.useCase

import com.example.shiftapp.data.database.BinRepository
import com.example.shiftapp.data.model.entity.BinRequestEntity
import com.example.shiftapp.data.net.ApiRepository
import com.example.shiftapp.domain.model.Bin
import com.example.shiftapp.domain.toEntity
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.*
import javax.inject.Inject
import javax.inject.Named

/*interface GetBinDetailsUseCase : FlowUseCase<GetBinDetailsUseCaseParams, Bin>*/

class GetBinDetailsUseCase @Inject constructor(
    private val binRepository: BinRepository,
    private val apiRepository: ApiRepository,
    @Named("IO")
    override val dispatcher: CoroutineDispatcher
) : FlowUseCase<GetBinDetailsUseCaseParams, Bin> {

    override fun execute(param: GetBinDetailsUseCaseParams): Flow<Result<Bin>> = flow {
        val result = apiRepository.getBinDetails(param.binNumber)
        binRepository.addBinResponse(
            BinRequestEntity(
                id = UUID.randomUUID(),
                binNumber = param.binNumber,
                bin = result.toEntity(),
                date = Date()
            )
        )
        emit(Result.success(result))
    }
}

data class GetBinDetailsUseCaseParams(
    val binNumber: String
)