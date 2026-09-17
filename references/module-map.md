# 模块地图

此地图基于源目录与 Maven 模块的只读盘点，仅表达职责推断，不复制源代码。

| 模块族 | 可见职责 | 复用时的关注点 |
| --- | --- | --- |
| `jc-club-gateway` | 网关、过滤器、Redis、异常转换 | 只做入口治理与协议适配 |
| `jc-club-auth` | 认证服务及 API/Application/Domain/Infra 分层 | 认证声明与业务授权职责分开 |
| `jc-club-subject` | 题库域及 API、应用、领域、基础设施模块 | 将题目规则放在领域/应用边界 |
| `jc-club-practice` | 练习服务与 API | 提交、进度和异步处理的幂等性 |
| `jc-club-circle` | 社区互动与 API | 内容/互动的权限与分页契约 |
| `jc-club-interview` | 面试服务与 API | 领域模型和外部交互隔离 |
| `jc-club-oss`、`jc-club-wx` | 对象存储与微信集成 | 第三方适配放在边界层 |
| `jc-club-common-starter`、`jc-club-gen` | 公共 starter 与生成工具 | 只共享稳定横切能力，避免共享领域模型 |

可操作的判断：一个功能若要同时改网关和三个领域服务，先重新审视其边界；多数情况下应通过稳定契约或事件协作，而不是共享数据库。
