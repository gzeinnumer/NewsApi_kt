package com.gzeinnumer.newsapikt.model

data class ResponseNewsApi(
	val totalResults: Int? = null,
	val articles: List<ArticlesItem>? = null,
	val status: String? = null
)
