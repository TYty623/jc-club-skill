# Community Platform Service Boundaries Skill

一个面向 Java/Spring Cloud 社区平台的可复用 Codex Skill，沉淀网关、认证、领域分层和跨服务契约的设计方法。

## 包含内容

- `SKILL.md`：从需求到服务归属、上下文传播和测试策略的实施指引。
- `references/`：平台的层次结构和模块能力地图。
- `examples/java/`：零依赖的已验证请求上下文值对象。

## 安装

将整个目录放入 Codex 的 skills 目录（常见位置为 `~/.codex/skills/`），然后在任务中引用 `$jc-club-skill`。

## 成果定位

该成果以程序员社区的业务形态为背景，抽象出可迁移到内容社区、学习平台和多服务后台的工程方法；它不复制源项目实现。

## 验证

```powershell
python <skill-creator>/scripts/quick_validate.py .
javac --release 17 -d .tmp examples\java\RequestScope.java
```

验证后可删除 `.tmp` 目录。
