import { ExamModel } from './examModel';
import { CacheModel } from './cacheModel';

export class QuestionModel{
    constructor(
        questionId : number,
        exam : ExamModel,
        question : string,
        option1 : string,
        option2 : string,
        option3 : string,
        option4 : string,
        correctAnswer : string,
        cacheEntry : Array<CacheModel>
    ){}
}