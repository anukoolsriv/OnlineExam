import { UserRegisterModel } from './UserRegisterModel';
import { ExamModel } from './ExamModel';
import { QuestionModel } from './QuestionModel';

export class CacheModel{
    constructor(
        cacheId: number,
        user : UserRegisterModel,
        exam : ExamModel,
        question : QuestionModel,
        ansSelected : string
    ){}
}